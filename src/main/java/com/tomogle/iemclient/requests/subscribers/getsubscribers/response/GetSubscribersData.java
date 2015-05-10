package com.tomogle.iemclient.requests.subscribers.getsubscribers.response;

import com.tomogle.iemclient.requests.lists.response.Item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class GetSubscribersData {

  private List<Item> item;

  public GetSubscribersData() {
  }

  public GetSubscribersData(final List<Item> item) {
    this.item = item;
  }

  @XmlElement
  public List<Item> getItem() {
    return item;
  }

  public void setItem(final List<Item> item) {
    this.item = item;
  }
}
