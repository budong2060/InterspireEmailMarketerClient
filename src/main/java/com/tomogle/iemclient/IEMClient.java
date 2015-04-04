package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.requests.CheckTokenDTO;
import com.tomogle.iemclient.response.ResponseDTO;
import com.tomogle.iemclient.response.Status;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class IEMClient {

  private WebTarget webTarget;

  public IEMClient(final String xmlApiUrl) {
    Client client = ClientBuilder.newClient();
    createWebTarget(client, xmlApiUrl);
  }

  public IEMClient(final ClientConfig clientConfig, final String xmlApiUrl) {
    Client client = ClientBuilder.newClient(clientConfig);
    createWebTarget(client, xmlApiUrl);
  }

  private void createWebTarget(final Client client, final String xmlApiUrl) {
    webTarget = client.target(xmlApiUrl);
  }


  public void checkToken(final CheckTokenDTO requestBody) throws OperationFailedException {
    final Response response = webTarget.request().post(Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE), Response.class);
    final ResponseDTO responseDTO = response.readEntity(ResponseDTO.class);
    final Status status = responseDTO.getStatus();
    if(! status.equals(Status.SUCCESS)) {
      throw new OperationFailedException(responseDTO.getErrorMessage(), responseDTO.getStatus());
    }
  }
}
