package com.mpsg.javaee.bean;

import java.util.Date;

public class BankAccountTransactionBuilder {
  
  private int accountNumber;
  private double amount;
  private Date txDate;
  private String txType;
  private int txId;

  public BankAccountTransactionBuilder setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public BankAccountTransactionBuilder setAmount(double amount) {
    this.amount = amount;
    return this;
  }

  public BankAccountTransactionBuilder setTxDate(Date txDate) {
    this.txDate = txDate;
    return this;
  }

  public BankAccountTransactionBuilder setTxType(String txType) {
    this.txType = txType;
    return this;
  }

  public BankAccountTransactionBuilder setTxId(int txId) {
    this.txId = txId;
    return this;
  }
  
  public BankAccountTransaction buildBankAccountTransaction() {
    return new BankAccountTransaction(accountNumber, amount, txDate, txType, txId);
  }
  
  
}
