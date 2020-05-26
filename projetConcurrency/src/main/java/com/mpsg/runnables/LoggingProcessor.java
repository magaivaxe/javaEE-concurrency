package com.mpsg.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingProcessor implements Callable<Boolean> {

  private final Logger LOGGER = Logger.getLogger(LoggingProcessor.class.getName());

  @Override
  public Boolean call() throws Exception {
    System.out.println(String.format("The thread name is - %s.", Thread.currentThread().getName()));
    LOGGER.log(Level.INFO, "Logging something");
    return true;
  }

}
