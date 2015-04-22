package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.ConnectionException;
import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.requests.RequestCreationUtil;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.AddSubscriberDTO;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.Confirmed;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.Format;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.ItemDTO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

  private static final String badToken = "badtoken";


  @BeforeClass
  public static void setUpClass() {
    final String apiUrl = properties.getProperty("iem.api.url");
    apiUsername = properties.getProperty("iem.api.username");
    apiToken = properties.getProperty("iem.api.token");
    testListId = properties.getProperty("iem.api.listid");
    client = new IEMClient(apiUrl, 2000, 2000);

  }

  @Test
  public void testCheckTokenSuccessfullyDoesNotThrow() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
  }

  @Test
  public void testCheckTokenTwiceSuccessfullyDoesNotThrow() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
  }

  @Test(expected = OperationFailedException.class)
  public void testCheckTokenWithWrongTokenThrowsOperationFailedException() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, badToken));
  }

  @Test(expected = ConnectionException.class)
  public void testCheckTokenWithBadURLThrowsConnectionException() throws Exception {
    IEMClient badClient = new IEMClient("http://badurl", 500, 500);
    badClient.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, badToken));
  }
  
  @Test
  public void testAddSubscriberToList() throws Exception {
    List<ItemDTO> customFields = new ArrayList<ItemDTO>();
    ItemDTO item1 = new ItemDTO(CustomFields.TITLE.ordinal() + 1, "Mr");
    ItemDTO item2 = new ItemDTO(CustomFields.FIRSTNAME.ordinal() + 1, "John");
    customFields.add(item1);
    customFields.add(item2);

    final String emailAddressToAdd = "some@address.tld";
    final AddSubscriberDTO addSubscriberDTO = RequestCreationUtil.addSubscriberDTO(apiUsername, apiToken, emailAddressToAdd, testListId,
        Format.text, Confirmed.yes, customFields);

    System.out.println(Utils.toXml(addSubscriberDTO));

    client.addSubscriberToList(addSubscriberDTO);
  }
}
