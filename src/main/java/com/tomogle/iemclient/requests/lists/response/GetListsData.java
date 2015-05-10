package com.tomogle.iemclient.requests.lists.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class GetListsData {

  private List<Item> item;

  public GetListsData() {
  }

  public GetListsData(final List<Item> item) {
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
