package com.tomogle.iemclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.fail;

public class PropertyUtil {

  public static Properties getTestProperties() {
    Properties properties = new Properties();
    InputStream is = null;
    try {
      is = PropertyUtil.class.getResourceAsStream("/iem.properties");
      properties.load(is);
    } catch(IOException e) {
      fail("Caught IOException when loading test properties");
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch(IOException e) {
          fail("Caught IOException when closing test properties InputStream");
        }
      }
    }
    return properties;
  }
}
