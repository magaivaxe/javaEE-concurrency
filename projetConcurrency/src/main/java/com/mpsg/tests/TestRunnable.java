package com.mpsg.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRunnable {

  public static void main(String[] args) {
    final Logger LOGGER = Logger.getLogger(TestRunnable.class.getName());

    Runnable runnable = () -> {
      try {
        File file = new File("src/main/resources/sample.txt");
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
    };
    // run with thread, allways a new thread
    // Thread thread = new Thread(runnable, "Thread read text");
    // thread.start();

    // run with executor, the thread commes from the thread pool
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(runnable);

  }

}
