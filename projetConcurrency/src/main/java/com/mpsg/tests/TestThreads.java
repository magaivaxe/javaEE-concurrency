package com.mpsg.tests;

import com.mpsg.runnables.ApplicationThread;

public class TestThreads {

  public static void main(String[] args) {
    ApplicationThread t1 = new ApplicationThread(); // new
    ApplicationThread t2 = new ApplicationThread();
    ApplicationThread t3 = new ApplicationThread();

    // random reader among all threads
    t1.start(); // runnable
    t2.start();
    t3.start();
  }

}
