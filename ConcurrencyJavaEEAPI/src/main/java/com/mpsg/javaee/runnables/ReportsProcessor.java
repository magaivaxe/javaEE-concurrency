package com.mpsg.javaee.runnables;

import com.mpsg.javaee.Constants;
import com.mpsg.javaee.bean.BankAccount;
import com.mpsg.javaee.bean.BankAccountTransaction;
import com.mpsg.javaee.dao.BankAccountDaoImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

public class ReportsProcessor implements Callable<Boolean>{
  
  private final BankAccount bankAccount;
  private final BankAccountDaoImpl bankAccountDao;
  
  private final String fileSuffix = "_tx_report.txt";

  public ReportsProcessor(BankAccount bankAccount, BankAccountDaoImpl bankAccountDao) {
    this.bankAccount = bankAccount;
    this.bankAccountDao = bankAccountDao;
  }

  @Override
  public Boolean call() throws Exception {
    System.out.println(Thread.currentThread().getName() + " generating report");
    List<BankAccountTransaction> transactions = bankAccountDao.getTransactions(bankAccount);
    File file = new File(Constants.URL_RAPORTS.getValue() + bankAccount.getAccNumber() + fileSuffix);
    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    
    for (BankAccountTransaction transaction : transactions) {
      bw.write("Account Number: " + transaction.getAccountNumber());
      bw.write("Transaction type: " + transaction.getTxType());
      bw.write("Tx Id: " + transaction.getTxId());
      bw.write("Amount: " + transaction.getAmount());
      bw.write("Transaction date: " + transaction.getTxDate());
      bw.newLine();
    }
    bw.flush();
    
    return true;
  }
  
}
