package com.mpsg.javaee.rest;

import com.mpsg.javaee.runnables.URLHealthProcessor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("urlCheck")
public class URLHealthResource {
  
  @Resource(lookup = "java:comp/DefaultManagedScheduledExecutorService")
  private ManagedScheduledExecutorService executorService;
  
  @GET
  public String checkHealthOfApp() {
    executorService.schedule(new URLHealthProcessor(), 3, TimeUnit.SECONDS);
    return "Health check initiated";
  }
  
}
