package com.tomogle.iemclient;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class IEMClientTestBase {
  protected IEMClient client;
  private static final Integer CONNECTION_TIMEOUT = 5000;
  private static final Integer READ_TIMEOUT = 5000;

  @Mocked WebTarget webTarget;
  @Mocked Client internalClient;
  @Mocked Invocation.Builder builder;
  @Mocked Response response;

  @Before
  public void setUp() {
    client = new IEMClient("http://someurl", CONNECTION_TIMEOUT, READ_TIMEOUT);
  }

  protected <T> void mockClientResponse(final T entity) {
    new NonStrictExpectations() {{
      internalClient.target(anyString); result = internalClient;
      webTarget.request(); result = builder;
      builder.post((Entity)any); result = response;
      response.readEntity(withAny(entity.getClass())); result = entity;
    }};
  }
}
