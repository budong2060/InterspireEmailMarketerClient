package com.tomogle.iemclient.requests.subscribers.addsubscribertolist;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class AddSubscriberRequest extends BaseRequest {

  private AddSubscriberDetails details;

  public AddSubscriberRequest() {
  }

  public AddSubscriberRequest(final String username, final String usertoken, final AddSubscriberDetails details) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.AddSubscriberToList);
    this.details = details;
  }

  @XmlElement(required = true)
  public AddSubscriberDetails getDetails() {
    return details;
  }

  public void setDetails(final AddSubscriberDetails details) {
    this.details = details;
  }
}