package com.mpsg.javaee.dao;

import com.mpsg.javaee.bean.BankAccount;
import com.mpsg.javaee.bean.BankAccountBuilder;
import com.mpsg.javaee.bean.BankAccountTransaction;
import com.mpsg.javaee.bean.BankAccountTransactionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class BankAccountDaoImpl implements CrudDao<BankAccount, Integer>, TransactionDao<BankAccountTransaction, BankAccount>{
  
  private DataSource dataSource;
  
  private final String TABLE_BANK_ACC = "bank_account";
  private final String COL_BAC_NUMBER = "acc_number";
  private final String COL_BAC_NAME = "acc_holder_name";
  private final String COL_BAC_EMAIL = "acc_email";
  private final String COL_BAC_TYPE = "acc_type";
  
  private final String TABLE_BANK_ACC_TRANSACTION = "bank_account_transaction";
  private final String COL_BAT_NUMBER = "acc_number";
  private final String COL_BAT_AMOUNT = "amount";
  private final String COL_BAT_DATE = "transaction_date";
  private final String COL_BAT_ID = "tx_id";
  private final String COL_BAT_TYPE = "transaction_type";

  public BankAccountDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  @Override
  public List<BankAccount> getAll() {
    List<BankAccount> accounts = new ArrayList<>();
    
    try {
      Connection connection = dataSource.getConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from " + TABLE_BANK_ACC);
      
      while (rs.next()) {
        accounts.add(new BankAccountBuilder()
          .setAccNumber(rs.getInt(COL_BAC_NUMBER))
          .setName(rs.getString(COL_BAC_NAME))
          .setEmail(rs.getString(COL_BAC_EMAIL))
          .setAccType(rs.getString(COL_BAC_TYPE))
          .buildBankAccount());
      }
    } catch (SQLException ex) {
      Logger.getLogger(BankAccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return accounts;
  }
  
  @Override
  public List<BankAccountTransaction> getTransactions(BankAccount bankAccount) {
    List<BankAccountTransaction> transactions = new ArrayList<>();
    
    try {
      Connection connection = dataSource.getConnection();
      PreparedStatement statement = connection.prepareStatement("select * from " + TABLE_BANK_ACC_TRANSACTION + " where " + COL_BAC_NUMBER + " = ?");
      statement.setInt(1, bankAccount.getAccNumber());
      ResultSet rs = statement.executeQuery();
      
      while (rs.next()) {
        transactions.add(new BankAccountTransactionBuilder()
          .setAccountNumber(rs.getInt(COL_BAT_NUMBER))
          .setAmount(rs.getDouble(COL_BAT_AMOUNT))
          .setTxDate(new Date(rs.getDate(COL_BAT_DATE).getTime()))
          .setTxId(rs.getInt(COL_BAT_ID))
          .setTxType(rs.getString(COL_BAT_TYPE))
          .buildBankAccountTransaction());
      }
    } catch (SQLException ex) {
      Logger.getLogger(BankAccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return transactions;
  }
  
  

  @Override
  public BankAccount getById(Integer v) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Integer delete(Integer v) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Integer set(BankAccount t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  
}
