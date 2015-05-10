package com.tomogle.iemclient.requests.subscribers.getsubscribers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class GetSubscriberDetails {

  private SearchInfo searchinfo;

  public GetSubscriberDetails() {
  }

  public GetSubscriberDetails(final SearchInfo searchinfo) {
    this.searchinfo = searchinfo;
  }

  @XmlElement(required = true)
  public SearchInfo getSearchinfo() {
    return searchinfo;
  }

  public void setSearchinfo(final SearchInfo searchinfo) {
    this.searchinfo = searchinfo;
  }
}
