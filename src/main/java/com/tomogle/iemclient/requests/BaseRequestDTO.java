package com.tomogle.iemclient.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class BaseRequestDTO {
  private String username;
  private String usertoken;
  private RequestType requesttype;
  private RequestMethod requestmethod;

  public BaseRequestDTO() {
  }

  public BaseRequestDTO(final String username, final String usertoken, final RequestType requesttype, final RequestMethod requestmethod) {
    this.username = username;
    this.usertoken = usertoken;
    this.requesttype = requesttype;
    this.requestmethod = requestmethod;
  }

  @XmlElement(required = true)
  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  @XmlElement(required = true)
  public String getUsertoken() {
    return usertoken;
  }

  public void setUsertoken(final String usertoken) {
    this.usertoken = usertoken;
  }

  @XmlElement(required = true)
  public RequestType getRequesttype() {
    return requesttype;
  }

  public void setRequesttype(final RequestType requesttype) {
    this.requesttype = requesttype;
  }

  @XmlElement(required = true)
  public RequestMethod getRequestmethod() {
    return requestmethod;
  }

  public void setRequestmethod(final RequestMethod requestmethod) {
    this.requestmethod = requestmethod;
  }
}
