package com.mpsg.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mpsg.custom.CustomThreadFactory;
import com.mpsg.runnables.LoggingProcessor;

public class TestThreadFactory {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3, new CustomThreadFactory());

    for (int i = 0; i < 6; i++) {
      executorService.submit(new LoggingProcessor());
    }

  }

}
