package com.tomogle.iemclient.exception;

public class UnexpectedResponseBodyException extends Exception {

  public UnexpectedResponseBodyException() {
  }

  public UnexpectedResponseBodyException(final String message) {
    super(message);
  }

  public UnexpectedResponseBodyException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public UnexpectedResponseBodyException(final Throwable cause) {
    super(cause);
  }

  public UnexpectedResponseBodyException(final String message, final Throwable cause, final boolean enableSuppression,
      final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
