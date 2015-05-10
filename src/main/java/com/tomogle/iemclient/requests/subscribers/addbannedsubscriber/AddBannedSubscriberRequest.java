package com.tomogle.iemclient.requests.subscribers.addbannedsubscriber;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class AddBannedSubscriberRequest extends BaseRequest {

  private Details details;

  public AddBannedSubscriberRequest(final String username, final String usertoken) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.AddBannedSubscriber);
  }

  public AddBannedSubscriberRequest() {
  }

  @XmlElement(required = true, name = "details")
  public Details getDetails() {
    return details;
  }

  public void setDetails(final Details details) {
    this.details = details;
  }
}
