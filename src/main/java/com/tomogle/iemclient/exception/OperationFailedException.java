package com.tomogle.iemclient.exception;

import com.tomogle.iemclient.response.Status;

public class OperationFailedException extends Exception {

  private Status status;

  public OperationFailedException(final String errorMessage, final Status status) {
    super(errorMessage);
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }
}
