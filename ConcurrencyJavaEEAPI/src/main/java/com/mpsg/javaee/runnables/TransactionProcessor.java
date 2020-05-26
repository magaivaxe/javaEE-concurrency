package com.mpsg.javaee.runnables;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.mpsg.javaee.ejbbeans.TransactionBean;

public class TransactionProcessor implements Runnable {

  private UserTransaction userTransaction;
  private TransactionBean transactionBean;

  public TransactionProcessor() {
    try {
      InitialContext context = new InitialContext();
      userTransaction = (UserTransaction) context.lookup("java:comp/UserTransaction");
      transactionBean = (TransactionBean) context.lookup("java:module/tx-bean");
    } catch (NamingException e) {
      Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, e);
    }

  }

  @Override
  public void run() {
    try {
      userTransaction.begin();
      transactionBean.saveBankAccountTransaction();
      transactionBean.saveBankAccountTransactionLog();
    } catch (SQLException | NotSupportedException | SystemException e) {
      try {
        userTransaction.rollback();
      } catch (IllegalStateException | SecurityException | SystemException ex) {
        Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

}
