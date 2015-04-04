package com.tomogle.iemclient;

import com.tomogle.iemclient.requests.RequestCreationUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

public class MyIT {

  private static final Properties properties = PropertyUtil.getTestProperties();;
  private static IEMClient client;
  private static String apiUsername;
  private static String apiToken;


  @BeforeClass
  public static void setUpClass() {
    final String apiUrl = properties.getProperty("iem.api.url");
    apiUsername = properties.getProperty("iem.api.username");
    apiToken = properties.getProperty("iem.api.token");
    client = new IEMClient(apiUrl);
  }

  @Test
  public void testCheckToken() throws Exception {
    client.checkToken(RequestCreationUtil.checkTokenDTO(apiUsername, apiToken));
  }
}
