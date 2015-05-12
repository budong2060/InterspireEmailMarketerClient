package com.tomogle.iemclient.requests.lists.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {

  private Integer listid;
  private String subscriberid;
  private String emailaddress;
  private String format;
  private String subscribedate;
  private Integer confirmed;
  private Integer unsubscribed;
  private Integer bounced;

  public Item() {
  }

  @XmlElement(name = "listid", required = true)
  public Integer getListid() {
    return listid;
  }

  public void setListid(final Integer listid) {
    this.listid = listid;
  }

  @XmlElement(name = "subscriberid")
  public String getSubscriberid() {
    return subscriberid;
  }

  public void setSubscriberid(final String subscriberid) {
    this.subscriberid = subscriberid;
  }

  @XmlElement(name = "emailaddress")
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(final String emailaddress) {
    this.emailaddress = emailaddress;
  }

  @XmlElement(name = "format")
  public String getFormat() {
    return format;
  }

  public void setFormat(final String format) {
    this.format = format;
  }

  @XmlElement(name = "subscribedate")
  public String getSubscribedate() {
    return subscribedate;
  }

  public void setSubscribedate(final String subscribedate) {
    this.subscribedate = subscribedate;
  }

  @XmlElement(name = "confirmed")
  public Integer getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(final Integer confirmed) {
    this.confirmed = confirmed;
  }

  @XmlElement(name = "unsubscribed")
  public Integer getUnsubscribed() {
    return unsubscribed;
  }

  public void setUnsubscribed(final Integer unsubscribed) {
    this.unsubscribed = unsubscribed;
  }

  @XmlElement(name = "bounced")
  public Integer getBounced() {
    return bounced;
  }

  public void setBounced(final Integer bounced) {
    this.bounced = bounced;
  }
}
