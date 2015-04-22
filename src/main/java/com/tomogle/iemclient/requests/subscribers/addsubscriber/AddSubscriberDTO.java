package com.tomogle.iemclient.requests.subscribers.addsubscriber;

import com.tomogle.iemclient.requests.BaseRequestDTO;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class AddSubscriberDTO extends BaseRequestDTO {

  private AddSubscriberDetailsDTO details;

  public AddSubscriberDTO() {
  }

  public AddSubscriberDTO(final String username, final String usertoken, final AddSubscriberDetailsDTO details) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.AddSubscriberToList);
    this.details = details;
  }

  @XmlElement(required = true)
  public AddSubscriberDetailsDTO getDetails() {
    return details;
  }

  public void setDetails(final AddSubscriberDetailsDTO details) {
    this.details = details;
  }
}