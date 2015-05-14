package com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class Details {

  private Status status;
  private String listid;
  private String subscriberid;

  public Details() {
  }

  public Details(final Status status, final String subscriberid) {
    this.status = status;
    this.subscriberid = subscriberid;
  }

  public Details(final Status status, final String listid, final String subscriberid) {
    this.status = status;
    this.listid = listid;
    this.subscriberid = subscriberid;
  }

  @XmlElement(name = "status")
  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }

  @XmlElement(name = "listid", required = false)
  public String getListid() {
    return listid;
  }

  public void setListid(final String listid) {
    this.listid = listid;
  }

  @XmlElement(name = "subscriberid")
  public String getSubscriberid() {
    return subscriberid;
  }

  public void setSubscriberid(final String subscriberid) {
    this.subscriberid = subscriberid;
  }
}
