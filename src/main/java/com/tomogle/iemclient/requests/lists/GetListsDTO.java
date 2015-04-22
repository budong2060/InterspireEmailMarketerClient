package com.tomogle.iemclient.requests.lists;

import com.tomogle.iemclient.requests.BaseRequestDTO;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class GetListsDTO extends BaseRequestDTO {

  private GetListsDetailsDTO details;

  public GetListsDTO() {
  }

  public GetListsDTO(final String username, final String usertoken, final GetListsDetailsDTO details) {
    super(username, usertoken, RequestType.lists, RequestMethod.GetLists);
    this.details = details;
  }

  @XmlElement(required = true)
  public GetListsDetailsDTO getDetails() {
    return details;
  }

  public void setDetails(final GetListsDetailsDTO details) {
    this.details = details;
  }
}
