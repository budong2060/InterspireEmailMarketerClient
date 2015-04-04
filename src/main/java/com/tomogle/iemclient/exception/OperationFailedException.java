package com.tomogle.iemclient.exception;

import com.tomogle.iemclient.response.Status;

public class OperationFailedException extends Exception {

  private String errorMessage;
  private Status status;

  public OperationFailedException(final String errorMessage, final Status status) {
    super();
    this.errorMessage = errorMessage;
    this.status = status;
  }
}
