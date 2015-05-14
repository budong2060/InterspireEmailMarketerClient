package com.tomogle.iemclient.requests.subscribers.issubscriberonlist;

import com.tomogle.iemclient.requests.subscribers.savesubscribercustomfield.SubscriberIds;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "details")
public class Details {

  private String subscriberid;
  private String list;

  public Details() {
  }

  public Details(final String subscriberid, final String list) {
    this.subscriberid = subscriberid;
    this.list = list;
  }

  @XmlElement(name = "subscriberid")
  public String getSubscriberid() {
    return subscriberid;
  }

  public void setSubscriberid(final String subscriberid) {
    this.subscriberid = subscriberid;
  }

  @XmlElement(name = "listids")
  public String getList() {
    return list;
  }

  public void setList(final String list) {
    this.list = list;
  }
}
