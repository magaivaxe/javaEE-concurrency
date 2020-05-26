package com.mpsg.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.Constants;

public class ApplicationThread extends Thread {

  private final Logger LOGGER = Logger.getLogger(ApplicationThread.class.getName());

  @Override
  public void run() {
    try {
      File file =
          new File(Constants.URL_SAMPLE.getValue());
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      
      while ((line = reader.readLine()) != null) {
        LOGGER.log(Level.INFO, Thread.currentThread().getName() + " - reading the line: " + line);
      }

      reader.close();
    } catch (IOException e) {
      String message = "File not found";
      LOGGER.log(Level.SEVERE, message, e);
    }
  }
}
