package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.response.GenericResponse;
import com.tomogle.iemclient.response.Status;
import mockit.Deencapsulation;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class CheckStatusIsSuccessTest extends IEMClientTestBase {

  @Test
  public void shouldNotThrowForSuccess() throws Exception {
    final GenericResponse response = new GenericResponse();
    response.setStatus(Status.SUCCESS);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", response);
  }

  @Test(expected = OperationFailedException.class)
  public void shouldThrowForError() throws Exception {
    final String errorMessage = "There was an error";
    final GenericResponse response = new GenericResponse();
    response.setStatus(Status.ERROR);
    response.setErrorMessage(errorMessage);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", response);
  }

  @Test(expected = OperationFailedException.class)
  public void shouldThrowForFailed() throws Exception {
    final String errorMessage = "There was an error";
    final GenericResponse response = new GenericResponse();
    response.setStatus(Status.FAILED);
    response.setErrorMessage(errorMessage);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", response);
  }
}
