package com.mpsg.runnables;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.Constants;

public class CleaningScheduler implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
    } catch (InterruptedException e) {
      Logger.getLogger(CleaningScheduler.class.getName()).log(Level.SEVERE, null, e);
    }
    File folder = new File(Constants.URL_FOLDER_TO_CLEAN.getValue());
    File[] files = folder.listFiles();

    long hoursMillis = TimeUnit.HOURS.toMillis(5);
    long minuteMillis = TimeUnit.MINUTES.toMillis(1);
    long daysMillis = TimeUnit.DAYS.toMillis(5);

    for (File file : files) {
      if (System.currentTimeMillis() - file.lastModified() > minuteMillis) {
        System.out.println(String.format("The file -> %s will be deleted", file.getName()));
        // file.delete();
      }
    }

  }

}
