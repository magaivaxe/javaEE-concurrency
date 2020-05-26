package com.mpsg.javaee.bean;

import java.util.Date;

public class BankAccountTransaction {
  
  private final int accountNumber;
  private final double amount;
  private final Date txDate;
  private final String txType;
  private final int txId;

  public BankAccountTransaction(int accountNumber, double amount, Date txDate, String txType, int txId) {
    this.accountNumber = accountNumber;
    this.amount = amount;
    this.txDate = txDate;
    this.txType = txType;
    this.txId = txId;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public double getAmount() {
    return amount;
  }

  public Date getTxDate() {
    return txDate;
  }

  public String getTxType() {
    return txType;
  }

  public int getTxId() {
    return txId;
  }

}
