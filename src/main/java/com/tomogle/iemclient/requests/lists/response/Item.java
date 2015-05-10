package com.tomogle.iemclient.requests.lists.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {

  private String listid;
  private String name;
  private String createdate;
  private Integer subscribecount;
  private Integer unsubscribecount;
  private String ownerid;
  private String username;
  private String fullname;

  public Item() {
  }

  @XmlElement(name = "listid", required = true)
  public String getListid() {
    return listid;
  }

  public void setListid(final String listid) {
    this.listid = listid;
  }

  @XmlElement
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @XmlElement
  public String getCreatedate() {
    return createdate;
  }

  public void setCreatedate(final String createdate) {
    this.createdate = createdate;
  }

  @XmlElement
  public Integer getSubscribecount() {
    return subscribecount;
  }

  public void setSubscribecount(final Integer subscribecount) {
    this.subscribecount = subscribecount;
  }

  @XmlElement
  public Integer getUnsubscribecount() {
    return unsubscribecount;
  }

  public void setUnsubscribecount(final Integer unsubscribecount) {
    this.unsubscribecount = unsubscribecount;
  }

  @XmlElement
  public String getOwnerid() {
    return ownerid;
  }

  public void setOwnerid(final String ownerid) {
    this.ownerid = ownerid;
  }

  @XmlElement
  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  @XmlElement
  public String getFullname() {
    return fullname;
  }

  public void setFullname(final String fullname) {
    this.fullname = fullname;
  }
}
