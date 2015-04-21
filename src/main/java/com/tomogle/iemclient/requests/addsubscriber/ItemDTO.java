package com.tomogle.iemclient.requests.addsubscriber;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ItemDTO {

  private Integer fieldid;
  private String value;

  public ItemDTO() {
  }

  public ItemDTO(final Integer fieldid, final String value) {
    this.fieldid = fieldid;
    this.value = value;
  }

  @XmlElement(required = true)
  public Integer getFieldid() {
    return fieldid;
  }

  public void setFieldid(final Integer fieldid) {
    this.fieldid = fieldid;
  }

  @XmlElement(required = true)
  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }
}
