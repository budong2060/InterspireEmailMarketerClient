package com.tomogle.iemclient.requests.subscribers.getsubscribers.response;

import com.tomogle.iemclient.requests.lists.response.Item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class GetSubscribersData {

  private Integer count;
  private SubscriberList subscriberlist;

  public GetSubscribersData() {
  }

  @XmlElement(name = "count")
  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  @XmlElement(name = "subscriberlist")
  public SubscriberList getSubscriberlist() {
    return subscriberlist;
  }

  public void setSubscriberlist(final SubscriberList subscriberlist) {
    this.subscriberlist = subscriberlist;
  }
}
