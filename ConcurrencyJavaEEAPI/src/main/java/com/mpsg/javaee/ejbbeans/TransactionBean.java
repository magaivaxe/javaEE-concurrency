package com.mpsg.javaee.ejbbeans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless(name = "tx-bean")
public class TransactionBean {
  
  @Resource(lookup = "jdbc/source1")
  private DataSource dataSource1;
  
  @Resource(lookup = "jdbc/source2")
  private DataSource dataSource2;

  public void saveBankAccountTransaction() throws SQLException {
    Connection connection = dataSource1.getConnection();
    Statement statement = connection.createStatement();
    statement.executeUpdate("insert into bank_account_transaction values(21, 1101, 'debit', 400, "
                            + new Date(System.currentTimeMillis()) + ")");
  }

  public void saveBankAccountTransactionLog() throws SQLException {
    Connection connection = dataSource2.getConnection();
    Statement statement = connection.createStatement();
    statement.executeUpdate("insert into bank_account_transaction_log values(3, 21, 'system', "
                            + new Date(System.currentTimeMillis()) + ")");
  }
  
  
  
}
