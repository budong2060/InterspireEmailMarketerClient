package com.tomogle.iemclient.requests.subscribers.getsubscribers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class GetSubscriberDetails {

  private SearchInfo searchinfo;
  private Boolean countonly;

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

  @XmlElement
  public Boolean getCountonly() {
    return countonly;
  }

  public void setCountonly(final Boolean countonly) {
    this.countonly = countonly;
  }
}
