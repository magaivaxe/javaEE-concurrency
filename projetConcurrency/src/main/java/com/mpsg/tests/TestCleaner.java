package com.mpsg.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.mpsg.runnables.CleaningScheduler;

public class TestCleaner {

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    // he scheduled method give the possibility to add delay to actions
    // executorService.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
    // to each 4 seconds the runnable is called after a delay of 5 seconds
    // executorService.scheduleAtFixedRate(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
    // to each 4 seconds + the time of last task to be acomplished
    executorService.scheduleWithFixedDelay(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
    //

  }

}
