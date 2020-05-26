package com.mpsg.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.tools.RunScript;

import com.mpsg.beans.Constants;

public class DataBaseH2 {

  private DataBaseH2() {
  }

  public static void initDB(Connection connection) {
    try {
      RunScript.execute(connection, new FileReader(new File(Constants.URL_SCRIPT_H2_DATABASE.getValue())));
      Logger.getLogger(DataBaseH2.class.getName()).log(Level.INFO, "Database createad");
    } catch (SQLException | FileNotFoundException e) {
      Logger.getLogger(DataBaseH2.class.getName()).log(Level.SEVERE, null, e);
    }
  }

}
