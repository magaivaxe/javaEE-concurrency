package com.mpsg.beans;

public enum Constants {

  URL_SAMPLE("src/main/resources/sample.txt"),
  URL_NEWUSERS("src/main/resources/new_users.txt"),
  URL_DATABASE("jdbc:mysql://localhost:3306/testUser"),
  URL_H2_DATABASE("jdbc:h2:~/userTest"),
  URL_SCRIPT_H2_DATABASE("src/main/resources/database.sql"),
  URL_FOLDER_TO_CLEAN("src/main/resources/folderToClean"),
  DELIMITER(",");

  private String value;

  private Constants(String url) {
    this.value = url;
  }

  public String getValue() {
    return value;
  }
}
