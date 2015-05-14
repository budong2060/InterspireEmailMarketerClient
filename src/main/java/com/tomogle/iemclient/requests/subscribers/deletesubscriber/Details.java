package com.tomogle.iemclient.requests.subscribers.deletesubscriber;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class Details {

  private String list;
  private String emailaddress;

  public Details() {
  }

  public Details(final String list, final String emailaddress) {
    this.list = list;
    this.emailaddress = emailaddress;
  }

  @XmlElement(required = true)
  public String getList() {
    return list;
  }

  public void setList(final String list) {
    this.list = list;
  }

  @XmlElement(required = true)
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(final String emailaddress) {
    this.emailaddress = emailaddress;
  }
}
