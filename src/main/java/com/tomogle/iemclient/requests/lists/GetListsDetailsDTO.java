package com.tomogle.iemclient.requests.lists;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class GetListsDetailsDTO {

  private int start;
  private int perpage;

  public GetListsDetailsDTO() {
  }

  public GetListsDetailsDTO(final int start, final int perpage) {
    this.start = start;
    this.perpage = perpage;
  }

  @XmlElement(required = true)
  public int getStart() {
    return start;
  }

  public void setStart(final int start) {
    this.start = start;
  }

  @XmlElement(required = true)
  public int getPerpage() {
    return perpage;
  }

  public void setPerpage(final int perpage) {
    this.perpage = perpage;
  }
}
