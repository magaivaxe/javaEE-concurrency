package com.mpsg.javaee.bean;

public class BankAccount {
  
  private int accNumber;
  private String name;
  private String email;
  private String accType;

  public BankAccount(int accNumber, String name, String email, String accType) {
    this.accNumber = accNumber;
    this.name = name;
    this.email = email;
    this.accType = accType;
  }

  public int getAccNumber() {
    return accNumber;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getAccType() {
    return accType;
  }
  
}
