package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.ConnectionException;
import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.requests.RequestCreationUtil;
import com.tomogle.iemclient.requests.lists.GetListsRequest;
import com.tomogle.iemclient.requests.lists.response.GetListsResponse;
import com.tomogle.iemclient.requests.stats.FetchStatsRequest;
import com.tomogle.iemclient.requests.stats.StatsType;
import com.tomogle.iemclient.requests.subscribers.addbannedsubscriber.AddBannedSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.AddSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Confirmed;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.CustomFields;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Format;
import com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm.ChangeSubscriberConfirmRequest;
import com.tomogle.iemclient.requests.subscribers.deletesubscriber.DeleteSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscriberDetails;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersCountRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.SearchInfo;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.response.GetSubscribersResponse;
import com.tomogle.iemclient.requests.subscribers.issubscriberonlist.Details;
import com.tomogle.iemclient.requests.subscribers.issubscriberonlist.IsSubscriberOnListRequest;
import com.tomogle.iemclient.response.GenericResponse;
import com.tomogle.iemclient.response.Status;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.tomogle.iemclient.Utils.toXml;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration tests that run against your IEM test deployment.
 * Put your IEM development deployment details in a file named iem.properties in the test/resources/ directory
 */
public class IEMClientIT {

  private static final Properties properties = PropertyUtil.getTestProperties();
  private static IEMClient client;
  private static String apiUsername;
  private static String apiToken;
  private static String testListId;

  private static final String BAD_TOKEN = "badtoken";

  private static final String EMAIL_ADDRESS = "xyz@mydomain.com";
  private static final String EMAIL_ADDRESS_TO_ADD = "some@address.tld";


  @BeforeClass
  public static void setUpClass() {
    final String apiUrl = properties.getProperty("iem.api.url");
    apiUsername = properties.getProperty("iem.api.username");
    apiToken = properties.getProperty("iem.api.token");
    testListId = properties.getProperty("iem.api.listid");
    client = new IEMClient(apiUrl, 2000, 2000);
  }

  // Check token

  @Test
  public void testCheckTokenSuccessfullyDoesNotThrow() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenRequest(apiUsername, apiToken));
  }

  @Test
  public void testCheckTokenTwiceSuccessfullyDoesNotThrow() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenRequest(apiUsername, apiToken));
    client.checkToken(RequestCreationUtil.checkTokenRequest(apiUsername, apiToken));
  }

  @Test(expected = OperationFailedException.class)
  public void testCheckTokenWithWrongTokenThrowsOperationFailedException() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenRequest(apiUsername, BAD_TOKEN));
  }

  @Test(expected = ConnectionException.class)
  public void testCheckTokenWithBadURLThrowsConnectionException() throws Exception {
    IEMClient badClient = new IEMClient("http://badurl", 500, 500);
    badClient.checkToken(RequestCreationUtil.checkTokenRequest(apiUsername, BAD_TOKEN));
  }

  
  @Test
  public void testAddSubscriberToList() throws Exception {
    List<CustomFields> customFields = new ArrayList<CustomFields>();
    CustomFields item1 = new CustomFields(Integer.toString(CustomFieldOptions.FIRSTNAME.ordinal() + 1), "John");
    CustomFields item2 = new CustomFields(Integer.toString(CustomFieldOptions.CITY.ordinal() + 1), "San Francisco");
    customFields.add(item1);
    customFields.add(item2);
    final AddSubscriberRequest addSubscriberRequest = RequestCreationUtil.addSubscriberRequest(apiUsername, apiToken,
        EMAIL_ADDRESS_TO_ADD,
        testListId,
        Format.text, Confirmed.yes, customFields);
    System.out.println(toXml(addSubscriberRequest));
    GenericResponse response = client.addSubscriberToList(addSubscriberRequest);
    assertNotNull(response);
    System.out.println(toXml(response));
  }

  // Delete subscriber

  @Ignore
  @Test
  public void testDeleteSubscriberFromList() throws Exception {
    DeleteSubscriberRequest deleteSubscriberRequest = RequestCreationUtil
        .deleteSubscriberRequest(apiUsername, apiToken, testListId, EMAIL_ADDRESS_TO_ADD);
    System.out.println(toXml(deleteSubscriberRequest));
    GenericResponse genericResponse = client.deleteSubscriberFromList(deleteSubscriberRequest);
    System.out.println(toXml(genericResponse));
  }

  // Get subscribers

  @Test
  public void testGetSubscribers() throws Exception {
    SearchInfo searchInfo = new SearchInfo();
    searchInfo.setList("any");
    GetSubscriberDetails details = new GetSubscriberDetails();
    details.setSearchinfo(searchInfo);
    GetSubscribersRequest request = new GetSubscribersRequest(apiUsername, apiToken, details);
    System.out.println(toXml(request));

    GetSubscribersResponse subscribers = client.getSubscribers(request);
    assertNotNull(subscribers);
    assertNotNull(subscribers.getStatus());
    assertEquals(Status.SUCCESS, subscribers.getStatus());
    assertNotNull(subscribers.getData());
    System.out.println(toXml(subscribers));
  }

  @Test
  public void testGetSubscribersCountOnly() throws Exception {
    GetSubscribersCountRequest request = RequestCreationUtil.getSubscribersCountRequest(apiUsername, apiToken, "any");
    System.out.println(toXml(request));

    GenericResponse subscriberCount = client.getSubscriberCount(request);
    assertNotNull(subscriberCount);
    assertNotNull(subscriberCount.getStatus());
    assertEquals(Status.SUCCESS, subscriberCount.getStatus());
    assertNotNull(subscriberCount.getData());
    System.out.println(toXml(subscriberCount));
  }

  // Get lists

  @Test
  public void testGetLists() throws Exception {
    GetListsRequest getListsRequest = RequestCreationUtil.getListsRequest(apiUsername, apiToken, 0, 200);
    GetListsResponse response = client.getLists(getListsRequest);
    System.out.println(toXml(response));
    assertNotNull("Could not get lists response", response);
    assertNotNull(response.getStatus());
  }

  // Is subscriber on list

  @Test
  public void testIsSubscriberOnList() throws Exception {
    String id = "18";
    IsSubscriberOnListRequest request = new IsSubscriberOnListRequest(apiUsername, apiToken);
    request.setDetails(new Details(id, testListId));
    GenericResponse result = client.isSubscriberOnList(request);
    System.out.println(toXml(result));
  }

  // Suppress subscriber

  @Test
  public void testSuppressSubscriberGlobally() throws Exception {
    AddBannedSubscriberRequest request = RequestCreationUtil
        .addBannedSubscriberGloballyRequest(apiUsername, apiToken, "globally@suppressed.com");
    client.suppressSubscriber(request);
  }

  @Test
  public void testSuppressSubscriberForOneList() throws Exception {
    AddBannedSubscriberRequest request = RequestCreationUtil
        .addBannedSubscriberToSingleListRequest(apiUsername, apiToken, "1", "onelist@suppressed.com");
    client.suppressSubscriber(request);
  }

  // Fetch stats

  @Test
  public void testFetchStats() throws Exception {
    FetchStatsRequest request = RequestCreationUtil.fetchStatsRequest(apiUsername, apiToken, "1", StatsType.a);
    String stats = client.fetchStats(request);
    System.out.println(stats);
  }

  @Test
  public void testChangeSubscriberConfirmStatusForAllLists() throws Exception {
    String subscriberid = "100";
    ChangeSubscriberConfirmRequest request = RequestCreationUtil
        .changeSubscriberConfirmStatusForAllLists(apiUsername, apiToken,
            com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm.Status.unconfirm, subscriberid);
    GenericResponse genericResponse = client.ChangeSubscriberConfirmStatus(request);
    System.out.println(toXml(genericResponse));
  }
}
