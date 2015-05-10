package com.tomogle.iemclient.requests.subscribers.issubscriberonlist;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class IsSubscriberOnListRequest extends BaseRequest {

  private Details details;

  public IsSubscriberOnListRequest() {
  }

  public IsSubscriberOnListRequest(final String username, final String usertoken) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.IsSubscriberOnList);
  }

  @XmlElement(name = "details")
  public Details getDetails() {
    return details;
  }

  public void setDetails(final Details details) {
    this.details = details;
  }
}
