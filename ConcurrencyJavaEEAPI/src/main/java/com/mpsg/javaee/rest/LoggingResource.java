package com.mpsg.javaee.rest;

import com.mpsg.javaee.runnables.LoggingProcessor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("logging")
public class LoggingResource {
  
  @Resource(lookup = "java:comp/DefaultManagedThreadFactory")
  private ManagedThreadFactory threadFactory;
  
  @GET
  public String logData() {
    Thread thread = threadFactory.newThread(new LoggingProcessor());
    thread.setName("Logging-thread");
    thread.start();
    ExecutorService service = getApplicationPool();
    
    for (int i = 0; i < 7; i++) {
      service.submit(new LoggingProcessor());
    }
    return "Logging thread doing its job, check console";
  }
  
  private ExecutorService getApplicationPool() {
    ExecutorService service = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(2), threadFactory);
    return service;
  }
  
}
