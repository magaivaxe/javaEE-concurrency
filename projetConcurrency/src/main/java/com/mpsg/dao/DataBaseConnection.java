package com.mpsg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.Constants;

public class DataBaseConnection {

  private DataBaseConnection() {}

  public static Connection getConnection() {
    String url = Constants.URL_H2_DATABASE.getValue();
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(url);
    } catch (SQLException e) {
      Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, e);
    }
    return connection;
  }

  public static void closeConnection(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
