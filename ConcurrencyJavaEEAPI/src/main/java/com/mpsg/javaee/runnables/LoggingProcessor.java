package com.mpsg.javaee.runnables;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingProcessor implements Runnable{

  @Override
  public void run() {
    System.out.println("Thread: " + Thread.currentThread().getName());
    Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging data for resource");
  }
  
}
