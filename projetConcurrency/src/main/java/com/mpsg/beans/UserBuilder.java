package com.mpsg.beans;

public class UserBuilder {

  private int id;
  private String name;
  private String emailAddress;

  public UserBuilder setId(int id) {
    this.id = id;
    return this;
  }

  public UserBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public UserBuilder setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  public User buildUser() {
    return new User(id, name, emailAddress);
  }

}
