package com.mpsg.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.runnables.LoggingProcessor;

public class TestOtherApis {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    List<Callable<Boolean>> callables = new ArrayList<>();

    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());
    callables.add(new LoggingProcessor());

    try {
      // invoke all callables
      List<Future<Boolean>> futures = executorService.invokeAll(callables);

      for (Future<Boolean> future : futures) {
        System.out.println("Operation result: " + future.get());
      }

    } catch (InterruptedException | ExecutionException e) {
      Logger.getLogger(TestOtherApis.class.getName()).log(Level.SEVERE, null, e);
    }

    try {
      // invoke any callable maybe 1, 2, 3 how many isn't sure
      executorService.invokeAny(callables);
    } catch (InterruptedException | ExecutionException e) {
      Logger.getLogger(TestOtherApis.class.getName()).log(Level.SEVERE, null, e);
    }

    // ******************* SHUTDOWN
    executorService.shutdown();

    try {
      System.out.println("System down? " + executorService.awaitTermination(30, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      Logger.getLogger(TestOtherApis.class.getName()).log(Level.SEVERE, null, e);
    }

  }
}
