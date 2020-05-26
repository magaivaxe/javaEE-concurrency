package com.mpsg.javaee.bean;

public class BankAccountBuilder {
  
  private int accNumber;
  private String name;
  private String email;
  private String accType;

  public BankAccountBuilder setAccNumber(int accNumber) {
    this.accNumber = accNumber;
    return this;
  }

  public BankAccountBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankAccountBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BankAccountBuilder setAccType(String accType) {
    this.accType = accType;
    return this;
  }
  
  public BankAccount buildBankAccount() {
    return new BankAccount(accNumber, name, email, accType);
  }
}
