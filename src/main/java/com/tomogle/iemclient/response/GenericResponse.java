package com.tomogle.iemclient.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class GenericResponse {

  private Status status;
  private String errormessage;
  private String data;

  public GenericResponse() {
  }

  @XmlElement(required = true)
  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }

  @XmlElement(name = "errormessage", required = false)
  public String getErrorMessage() {
    return errormessage;
  }

  public void setErrorMessage(final String errorMessage) {
    this.errormessage = errorMessage;
  }

  @XmlElement(name = "data", required = false)
  public String getData() {
    return data;
  }

  public void setData(final String data) {
    this.data = data;
  }
}