package com.tomogle.iemclient.requests.subscribers.getsubscribers.response;

import com.tomogle.iemclient.response.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class GetSubscribersResponse {

  private Status status;
  private GetSubscribersData data;

  public GetSubscribersResponse() {
  }

  @XmlElement(required = true)
  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }

  @XmlElement(name = "data", required = true)
  public GetSubscribersData getData() {
    return data;
  }

  public void setData(final GetSubscribersData data) {
    this.data = data;
  }
}
