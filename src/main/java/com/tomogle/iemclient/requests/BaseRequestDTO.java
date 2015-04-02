package com.tomogle.iemclient.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseRequestDTO {

  @XmlElement(required = true)
  private String username;
  @XmlElement(required = true)
  private String usertoken;
  @XmlElement(required = true)
  private RequestType requesttype;
  @XmlElement(required = true)
  private RequestType requestmethod;

  public BaseRequestDTO() {
  }

  public BaseRequestDTO(final String username, final String usertoken, final RequestType requesttype,
      final RequestType requestmethod) {
    this.username = username;
    this.usertoken = usertoken;
    this.requesttype = requesttype;
    this.requestmethod = requestmethod;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getUsertoken() {
    return usertoken;
  }

  public void setUsertoken(final String usertoken) {
    this.usertoken = usertoken;
  }

  public RequestType getRequesttype() {
    return requesttype;
  }

  public void setRequesttype(final RequestType requesttype) {
    this.requesttype = requesttype;
  }

  public RequestType getRequestmethod() {
    return requestmethod;
  }

  public void setRequestmethod(final RequestType requestmethod) {
    this.requestmethod = requestmethod;
  }

  @Override public boolean equals(final Object o) {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;

    BaseRequestDTO that = (BaseRequestDTO) o;

    if(username != null ? !username.equals(that.username) : that.username != null)
      return false;
    if(usertoken != null ? !usertoken.equals(that.usertoken) : that.usertoken != null)
      return false;
    if(requesttype != that.requesttype)
      return false;
    return requestmethod == that.requestmethod;

  }

  @Override public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (usertoken != null ? usertoken.hashCode() : 0);
    result = 31 * result + (requesttype != null ? requesttype.hashCode() : 0);
    result = 31 * result + (requestmethod != null ? requestmethod.hashCode() : 0);
    return result;
  }
}
