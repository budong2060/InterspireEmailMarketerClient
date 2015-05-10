package com.tomogle.iemclient.requests.subscribers.getsubscribers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "searchinfo")
public class SearchInfo {

  private String list;
  private String email;
  private Integer confirmed;
  private String subscriber;

  public SearchInfo() {
  }

  public SearchInfo(final String list, final String email) {
    this.list = list;
    this.email = email;
  }

  @XmlElement(name = "List")
  public String getList() {
    return list;
  }

  public void setList(final String list) {
    this.list = list;
  }

  @XmlElement(name = "Email")
  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  @XmlElement(name = "Confirmed")
  public Integer getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(final Integer confirmed) {
    this.confirmed = confirmed;
  }

  @XmlElement(name = "Subscriber")
  public String getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(final String subscriber) {
    this.subscriber = subscriber;
  }
}
