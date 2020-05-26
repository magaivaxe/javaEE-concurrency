package com.mpsg.javaee.rest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mpsg.javaee.bean.BankAccount;
import com.mpsg.javaee.dao.BankAccountDaoImpl;
import com.mpsg.javaee.runnables.ReportsProcessor;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("reports")
public class ReportsResource {

  @Resource(lookup = "java:comp/DefaultManagedExecutorService")
  private ManagedExecutorService executorService;
  
  private final BankAccountDaoImpl bankAccountDao;

  public ReportsResource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testConcurrency");
      dataSource.setDriverClass("com.mysql.jdbc.Driver");
    dataSource.setUser("admin");
    dataSource.setPassword("admin");
    bankAccountDao = new BankAccountDaoImpl(dataSource);
  }
  
  @GET
  public String generateReports() throws InterruptedException, ExecutionException {
    System.out.println("service object from JNDI look up: " + executorService);
    List<BankAccount> accounts = bankAccountDao.getAll();
    
    for (BankAccount account : accounts) {
      Future<Boolean> future = executorService.submit(new ReportsProcessor(account, bankAccountDao));
      System.out.println("report generated? " + future.get());
    }
    
    return "Report generation tasks submitted!";
  }
  
  
  
  
}
