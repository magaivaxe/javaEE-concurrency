package com.mpsg.javaee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetUser")
public class GreetResource {

  @GET
  public String greetUser() {
    return "Java EE consurrency starts!";
  }

}
