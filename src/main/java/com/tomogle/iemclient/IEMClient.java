package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.ConnectionException;
import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.exception.UnexpectedResponseBodyException;
import com.tomogle.iemclient.exception.UnexpectedResponseCodeException;
import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.authentication.checktoken.CheckTokenRequest;
import com.tomogle.iemclient.requests.lists.GetListsRequest;
import com.tomogle.iemclient.requests.lists.response.GetListsResponse;
import com.tomogle.iemclient.requests.stats.FetchStatsRequest;
import com.tomogle.iemclient.requests.subscribers.addbannedsubscriber.AddBannedSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.AddSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm.ChangeSubscriberConfirmRequest;
import com.tomogle.iemclient.requests.subscribers.deletesubscriber.DeleteSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersCountRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.response.GetSubscribersResponse;
import com.tomogle.iemclient.requests.subscribers.issubscriberonlist.IsSubscriberOnListRequest;
import com.tomogle.iemclient.requests.subscribers.savesubscribercustomfield.SaveSubscriberCustomFieldRequest;
import com.tomogle.iemclient.response.GenericResponse;
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
import javax.xml.bind.JAXBException;

import static com.tomogle.iemclient.Utils.fromXml;
import static com.tomogle.iemclient.Utils.toXml;

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
  public void checkToken(final CheckTokenRequest requestBody)
      throws OperationFailedException, ConnectionException, UnexpectedResponseCodeException {
    try {
      final Response response = webTarget.request().post(Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE), Response.class);
      checkResponseCode(response, OK_RESPONSE);
      final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
      checkStatusIsSuccess(responseEntity);
    } catch (InternalServerErrorException e) {
      throw new ConnectionException(e);
    }
  }

  public GetListsResponse getLists(final GetListsRequest requestBody)
      throws UnexpectedResponseCodeException, OperationFailedException, ConnectionException, UnexpectedResponseBodyException {
    try {
      final Response response = webTarget.request().post(Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE), Response.class);
      checkResponseCode(response, OK_RESPONSE);
      String responseString = response.readEntity(String.class);
      return fromXml(responseString, GetListsResponse.class);
    } catch (InternalServerErrorException e) {
      throw new ConnectionException(e);
    } catch(JAXBException e) {
      throw new UnexpectedResponseBodyException(e);
    }
  }

  public GetSubscribersResponse getSubscribers(final GetSubscribersRequest requestBody)
      throws UnexpectedResponseCodeException, OperationFailedException, ConnectionException, UnexpectedResponseBodyException {
    try {
      Entity<GetSubscribersRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
      final Response response = webTarget.request().post(entity, Response.class);
      checkResponseCode(response, OK_RESPONSE);
      String responseString = response.readEntity(String.class);
      return fromXml(responseString, GetSubscribersResponse.class);
    } catch (InternalServerErrorException e) {
      throw new ConnectionException(e);
    } catch(JAXBException e) {
      throw new UnexpectedResponseBodyException(e);
    }
  }

  public GenericResponse getSubscriberCount(final GetSubscribersCountRequest requestBody)
      throws UnexpectedResponseCodeException, OperationFailedException, ConnectionException, UnexpectedResponseBodyException {
    try {
      Entity<GetSubscribersCountRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
      final Response response = webTarget.request().post(entity, Response.class);
      checkResponseCode(response, OK_RESPONSE);
      String responseString = response.readEntity(String.class);
      return fromXml(responseString, GenericResponse.class);
    } catch (InternalServerErrorException e) {
      throw new ConnectionException(e);
    } catch(JAXBException e) {
      throw new UnexpectedResponseBodyException(e);
    }
  }

  // If they are not on the list, they are added.
  // Then each of the custom fields are associated with the subscriber if necessary.
  public GenericResponse addSubscriberToList(final AddSubscriberRequest requestBody) throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<AddSubscriberRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
    checkStatusIsSuccess(responseEntity);
    return responseEntity;
  }

  public GenericResponse deleteSubscriberFromList(final DeleteSubscriberRequest requestBody)
      throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<DeleteSubscriberRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
    checkStatusIsSuccess(responseEntity);
    return responseEntity;
  }

  public GenericResponse isSubscriberOnList(final IsSubscriberOnListRequest requestBody) throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<IsSubscriberOnListRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    return response.readEntity(GenericResponse.class);
  }

  public GenericResponse suppressSubscriber(final AddBannedSubscriberRequest requestBody) throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<AddBannedSubscriberRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
    checkStatusIsSuccess(responseEntity);
    return responseEntity;
  }

  public String fetchStats(final FetchStatsRequest requestBody) throws UnexpectedResponseCodeException, OperationFailedException {
    Entity<FetchStatsRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    return response.readEntity(String.class);
  }

  /**
   * If an incorrect subscriber ID is provided then this method will report success.
   */
  public GenericResponse changeSubscriberConfirmStatus(final ChangeSubscriberConfirmRequest requestBody)
      throws OperationFailedException, UnexpectedResponseCodeException, JAXBException {
    Entity<ChangeSubscriberConfirmRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
    checkStatusIsSuccess(responseEntity);
    return responseEntity;
  }

  public GenericResponse saveSubscriberCustomField(final SaveSubscriberCustomFieldRequest requestBody)
      throws OperationFailedException, UnexpectedResponseCodeException, JAXBException {
    Entity<SaveSubscriberCustomFieldRequest> entity = Entity.entity(requestBody, MediaType.APPLICATION_XML_TYPE);
    final Response response = webTarget.request().post(entity, Response.class);
    checkResponseCode(response, OK_RESPONSE);
    final GenericResponse responseEntity = response.readEntity(GenericResponse.class);
    checkStatusIsSuccess(responseEntity);
    return responseEntity;
  }

  private void checkStatusIsSuccess(final GenericResponse response) throws OperationFailedException {
    final Status status = response.getStatus();
    if(!status.equals(Status.SUCCESS)) {
      throw new OperationFailedException(response.getErrorMessage(), response.getStatus());
    }
  }

  private void checkResponseCode(final javax.ws.rs.core.Response response, final int[] expectedStatusArray) throws UnexpectedResponseCodeException {
    final int actualStatus = response.getStatus();
    for(int status : expectedStatusArray) {
      if(status == actualStatus)
        return;
    }
    throw new UnexpectedResponseCodeException(expectedStatusArray,actualStatus);
  }

}
