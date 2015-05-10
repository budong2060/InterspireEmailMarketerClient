package com.tomogle.iemclient.requests.subscribers.getsubscribers;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class GetSubscribersRequest extends BaseRequest {

  private GetSubscriberDetails details;

  public GetSubscribersRequest() {
  }

  public GetSubscribersRequest(final String username, final String usertoken, final GetSubscriberDetails details) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.GetSubscribers);
    this.details = details;
  }

  @XmlElement(required = true)
  public GetSubscriberDetails getDetails() {
    return details;
  }

  public void setDetails(final GetSubscriberDetails details) {
    this.details = details;
  }
}
