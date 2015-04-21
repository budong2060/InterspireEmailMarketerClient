package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.ConnectionException;
import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.exception.UnexpectedResponseCodeException;
import com.tomogle.iemclient.requests.CheckTokenDTO;
import com.tomogle.iemclient.requests.addsubscriber.AddSubscriberDTO;
import com.tomogle.iemclient.response.ResponseDTO;
import com.tomogle.iemclient.response.Status;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class IEMClient {

  private static final int[] OK_RESPONSE = new int[] {200};

  private WebTarget webTarget;

  public IEMClient(final String xmlApiUrl, final int connectionTimeout, final int readTimeout) {
    Client client = ClientBuilder.newClient()
                                 .property(ClientProperties.CONNECT_TIMEOUT, connectionTimeout)
                                 .property(ClientProperties.READ_TIMEOUT, readTimeout);
    createWebTarget(client, xmlApiUrl);
  }

  public IEMClient(final ClientConfig clientConfig, final String xmlApiUrl, final int connectionTimeout, final int readTimeout) {
    Client client = ClientBuilder.newClient(clientConfig)
                                 .property(ClientProperties.CONNECT_TIMEOUT, connectionTimeout)
                                 .property(ClientProperties.READ_TIMEOUT, readTimeout);
    createWebTarget(client, xmlApiUrl);
  }

  private void createWebTarget(final Client client, final String xmlApiUrl) {
    webTarget = client.target(xmlApiUrl);
  }

  /**
   * Used for testing your connection to the IEM API.
   * @param requestBody A data transfer object representing the XML request body.
   * @throws OperationFailedException Thrown if the server response indicates operation failure.
   */
  public void checkToken(final CheckTokenDTO requestBody)
      throws OperationFailedException, ConnectionException, UnexpectedResponseCodeException {
    try {
      final Response response = webTarget.request().post(Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE), Response.class);
      checkResponseCode(response, OK_RESPONSE);
      final ResponseDTO responseDTO = response.readEntity(ResponseDTO.class);
      checkStatusIsSuccess(responseDTO);
    } catch (InternalServerErrorException e) {
      throw new ConnectionException(e);
    }
  }

  public void addSubscriberToList(final AddSubscriberDTO requestBody) throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<AddSubscriberDTO> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final ResponseDTO responseDTO = response.readEntity(ResponseDTO.class);
    checkStatusIsSuccess(responseDTO);
  }

  private void checkStatusIsSuccess(final ResponseDTO responseDTO) throws OperationFailedException {
    final Status status = responseDTO.getStatus();
    if(!status.equals(Status.SUCCESS)) {
      throw new OperationFailedException(responseDTO.getErrorMessage(), responseDTO.getStatus());
    }
  }

  private void checkResponseCode(final Response response, final int[] expectedStatusArray) throws UnexpectedResponseCodeException {
    final int actualStatus = response.getStatus();
    for(int status : expectedStatusArray) {
      if(status == actualStatus)
        return;
    }
    throw new UnexpectedResponseCodeException(expectedStatusArray,actualStatus);
  }

}
