package com.mpsg.javaee.rest;

import com.mpsg.javaee.runnables.ContextServiceRunnable;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("contextservice")
public class ContextServiceAPIResource {
  
  @Resource(lookup = "java:comp/DefaultContextService")
  ContextService contextService;
  
  @GET
  public String accessSecurityInfo() {
    ContextServiceRunnable runnable = new ContextServiceRunnable();
    Runnable proxy = contextService.createContextualProxy(runnable, Runnable.class);
    
    Thread thread = new Thread(proxy);
    thread.start();

  return "Context capturing information";
  }
  
}
