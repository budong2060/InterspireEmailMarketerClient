package com.tomogle.iemclient.requests.subscribers.savesubscribercustomfield;

import javax.xml.bind.annotation.XmlElement;

public class SubscriberIds {

  private String id;

  public SubscriberIds() {
  }

  public SubscriberIds(final String id) {
    this.id = id;
  }

  @XmlElement(required = true, name = "id")
  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }
}
