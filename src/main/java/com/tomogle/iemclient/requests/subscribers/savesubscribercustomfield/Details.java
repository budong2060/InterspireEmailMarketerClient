package com.tomogle.iemclient.requests.subscribers.savesubscribercustomfield;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "details")
public class Details {

  private List<SubscriberIds> subscriberids;
  private String fieldid;
  private String data;

  public Details() {
  }

  public Details(final List<SubscriberIds> subscriberids, final String fieldid, final String data) {
    this.subscriberids = subscriberids;
    this.fieldid = fieldid;
    this.data = data;
  }

  @XmlElement(name = "fieldid")
  public String getFieldid() {
    return fieldid;
  }

  public void setFieldid(final String fieldid) {
    this.fieldid = fieldid;
  }

  @XmlElement(name = "data")
  public String getData() {
    return data;
  }

  public void setData(final String data) {
    this.data = data;
  }

  @XmlElement(name = "subscriberids")
  public List<SubscriberIds> getSubscriberids() {
    return subscriberids;
  }

  public void setSubscriberids(
      final List<SubscriberIds> subscriberids) {
    this.subscriberids = subscriberids;
  }
}
