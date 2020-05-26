package com.mpsg.javaee;

public enum Constants {
  URL_RAPORTS("src/main/resources/reports"),
  URL_SCRIPT_H2_DATABASE(""),
  URL_H2_DATABASE("");
  
  private String value;

  private Constants(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
