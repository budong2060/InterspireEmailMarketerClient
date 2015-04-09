package com.tomogle.iemclient;

import com.tomogle.iemclient.exception.OperationFailedException;
import com.tomogle.iemclient.response.ResponseDTO;
import com.tomogle.iemclient.response.Status;
import mockit.Deencapsulation;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class CheckStatusIsSuccessTest extends IEMClientTestBase {

  @Test
  public void shouldNotThrowForSuccess() throws Exception {
    final ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setStatus(Status.SUCCESS);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", responseDTO);
  }

  @Test(expected = OperationFailedException.class)
  public void shouldThrowForError() throws Exception {
    final String errorMessage = "There was an error";
    final ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setStatus(Status.ERROR);
    responseDTO.setErrorMessage(errorMessage);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", responseDTO);
  }

  @Test(expected = OperationFailedException.class)
  public void shouldThrowForFailed() throws Exception {
    final String errorMessage = "There was an error";
    final ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setStatus(Status.FAILED);
    responseDTO.setErrorMessage(errorMessage);
    Deencapsulation.invoke(client, "checkStatusIsSuccess", responseDTO);
  }
}
