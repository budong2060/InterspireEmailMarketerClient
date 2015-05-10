package com.tomogle.iemclient.requests.subscribers.issubscriberonlist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class Details {

  private String email;
  private String list;

  public Details() {
  }

  public Details(final String email, final String list) {
    this.email = email;
    this.list = list;
  }

  @XmlElement(name = "emailaddress")
  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  @XmlElement(name = "listids")
  public String getList() {
    return list;
  }

  public void setList(final String list) {
    this.list = list;
  }
}
