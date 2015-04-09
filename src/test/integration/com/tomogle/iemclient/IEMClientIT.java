package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.ConnectionException;
import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.requests.RequestCreationUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import java.net.UnknownHostException;
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
  private static final String badToken = "badtoken";


  @BeforeClass
  public static void setUpClass() {
    final String apiUrl = properties.getProperty("iem.api.url");
    apiUsername = properties.getProperty("iem.api.username");
    apiToken = properties.getProperty("iem.api.token");
    client = new IEMClient(apiUrl, 2000, 2000);
  }

  @Test
  public void testCheckToken() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
  }

  @Test(expected = OperationFailedException.class)
  public void testCheckTokenWrongTokenThrowsOperationFailedException() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, badToken));
  }

  @Test(expected = ConnectionException.class)
  public void testCheckTokenBadURL() throws Exception {
    IEMClient badClient = new IEMClient("http://badurl", 500, 500);
    badClient.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, badToken));
  }

  @Test
  public void testCheckTokenTwice() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
  }
}
