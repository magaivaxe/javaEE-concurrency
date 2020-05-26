package com.mpsg.javaee.dao;

import com.mpsg.javaee.bean.BankAccount;
import com.mpsg.javaee.bean.BankAccountTransaction;
import java.util.List;

interface TransactionDao<T, V> {
  
  public List<T> getTransactions(V v);
}
