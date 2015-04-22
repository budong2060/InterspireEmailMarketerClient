package com.tomogle.iemclient.requests;

/**
 * Represents a type of request in the IEM API.
 * According to the IEM API docs, it represents the 'name of the API file in question'.
 *
 * We ignore the Java uppercase enum naming convention for ease of use.
 */
public enum RequestType {
  subscribers,
  authentication,
  lists
}
