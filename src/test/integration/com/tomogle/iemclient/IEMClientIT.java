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
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Format;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Item;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscriberDetails;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.SearchInfo;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.response.GetSubscribersResponse;
import com.tomogle.iemclient.requests.subscribers.issubscriberonlist.Details;
import com.tomogle.iemclient.requests.subscribers.issubscriberonlist.IsSubscriberOnListRequest;
import com.tomogle.iemclient.response.Status;
import org.junit.BeforeClass;
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




    List<Item> customFields = new ArrayList<Item>();
    Item item1 = new Item(CustomFields.TITLE.ordinal() + 1, "Mr");
    Item item2 = new Item(CustomFields.FIRSTNAME.ordinal() + 1, "John");
    customFields.add(item1);
    customFields.add(item2);

    final AddSubscriberRequest addSubscriberRequestDTO = RequestCreationUtil.addSubscriberRequest(apiUsername, apiToken,
        EMAIL_ADDRESS_TO_ADD,
        testListId,
        Format.text, Confirmed.yes, customFields);

    System.out.println(toXml(addSubscriberRequestDTO));

    client.addSubscriberToList(addSubscriberRequestDTO);
  }

  // Get subscribers

  @Test
  public void testGetSubscribers() throws Exception {
    SearchInfo searchInfo = new SearchInfo();
    searchInfo.setList(testListId);
    GetSubscriberDetails details = new GetSubscriberDetails();
    details.setSearchinfo(searchInfo);
    GetSubscribersRequest request = new GetSubscribersRequest(apiUsername, apiToken, details);

    GetSubscribersResponse subscribers = client.getSubscribers(request);
    assertNotNull(subscribers);
    assertNotNull(subscribers.getStatus());
    assertEquals(Status.SUCCESS, subscribers.getStatus());
    assertNotNull(subscribers.getData());
  }

  // Get lists

  @Test
  public void testGetLists() throws Exception {
    GetListsRequest getListsRequest = RequestCreationUtil.getListsRequest(apiUsername, apiToken, 0, 200);
    GetListsResponse response = client.getLists(getListsRequest);
    assertNotNull("Could not get lists response", response);
    assertNotNull(response.getStatus());
    assertEquals(Status.SUCCESS, response.getStatus());
    assertNotNull(response.getData());
  }

  // Is subscriber on list

  @Test
  public void testIsSubscriberOnList() throws Exception {
    IsSubscriberOnListRequest request = new IsSubscriberOnListRequest(apiUsername, apiToken);
    request.setDetails(new Details(EMAIL_ADDRESS_TO_ADD, testListId));
    boolean result = client.isSubscriberOnList(request);
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
}
