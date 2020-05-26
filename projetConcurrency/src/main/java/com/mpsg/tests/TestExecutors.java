package com.mpsg.tests;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.Constants;
import com.mpsg.dao.DataBaseConnection;
import com.mpsg.dao.DataBaseH2;
import com.mpsg.dao.UserDao;
import com.mpsg.runnables.UserProcessor;
import com.mpsg.tests.utils.ProjectFileReader;

public class TestExecutors {

  public static void main(String[] args) {
    Connection connection = DataBaseConnection.getConnection();
    DataBaseH2.initDB(connection);
    DataBaseConnection.closeConnection(connection);
    UserDao userDao = new UserDao();

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    for (String userRecord : ProjectFileReader.getLinesFromFile(Constants.URL_NEWUSERS.getValue())) {
      /**
       * When the sibmit is called the executor service call the callable on userProcessor. If we
       * run with put get the future object the main thread will not be locked
       */
      Future<Integer> future = executorService.submit(new UserProcessor(userRecord, userDao));
      // try {
      // System.out.println("Result of operation is: " + future.get());
      // } catch (InterruptedException | ExecutionException e) {
      // Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
      // }
    }
    executorService.shutdown();
    Logger.getLogger(TestExecutors.class.getName()).log(Level.INFO, "Main execution over.");

    System.out.println(userDao.getAll());
    System.out.println("Users deleted: " + userDao.deleteAll());
  }
}
