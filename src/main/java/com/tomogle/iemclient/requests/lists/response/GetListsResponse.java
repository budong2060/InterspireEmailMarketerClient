package com.tomogle.iemclient.requests.lists.response;

import com.tomogle.iemclient.response.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class GetListsResponse {

  private Status status;
  private GetListsData data;

  public GetListsResponse() {
  }

  @XmlElement(required = true)
  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }

  @XmlElement(name = "data", required = true)

  public GetListsData getData() {
    return data;
  }

  public void setData(final GetListsData data) {
    this.data = data;
  }
}
