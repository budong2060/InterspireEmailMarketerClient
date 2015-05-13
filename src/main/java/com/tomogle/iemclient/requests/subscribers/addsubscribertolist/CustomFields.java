package com.tomogle.iemclient.requests.subscribers.addsubscribertolist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class CustomFields {

  private String fieldid;
  private String value;

  public CustomFields() {
  }

  public CustomFields(final String fieldid, final String value) {
    this.fieldid = fieldid;
    this.value = value;
  }

  @XmlElement(required = true, name = "fieldid")
  public String getFieldid() {
    return fieldid;
  }

  public void setFieldid(final String fieldid) {
    this.fieldid = fieldid;
  }

  @XmlElement(required = true, name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }
}
