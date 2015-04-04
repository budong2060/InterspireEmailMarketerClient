package com.tomogle.iemclient.requests;

public class RequestCreationUtil {

  public static CheckTokenDTO checkTokenDTO(final String apiUsername, final String apiToken) {
    return new CheckTokenDTO(apiUsername, apiToken, RequestType.authentication, RequestMethod.xmlapitest);
  }
}
