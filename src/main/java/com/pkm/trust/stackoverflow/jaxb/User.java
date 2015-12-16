package com.pkm.trust.stackoverflow.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class User {
  long id;
  
  String displayName;

  public long getId() {
    return id;
  }
  
  @XmlAttribute( name = "Id")
  public void setId(long id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  @XmlAttribute( name = "DisplayName")
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}
