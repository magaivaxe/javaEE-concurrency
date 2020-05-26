package com.mpsg.javaee.runnables;

import java.security.AccessControlContext;
import java.security.AccessController;
import javax.security.auth.Subject;

public class ContextServiceRunnable implements Runnable{

  @Override
  public void run() {
    System.out.println("Thread " + Thread.currentThread().getName());
    Subject subject = Subject.getSubject(AccessController.getContext());
    System.out.println("Security information from: " + subject);
  }
  
}
