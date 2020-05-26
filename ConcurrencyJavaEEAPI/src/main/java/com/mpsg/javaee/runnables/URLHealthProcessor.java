/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpsg.javaee.runnables;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLHealthProcessor implements Runnable {
  
  private final String URL_NAME = "http://www.google.com";

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " checking health");
    String statusApp = "";
    URL url;
    try {
      url = new URL(URL_NAME);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      int responseCode = connection.getResponseCode();
      
      if (responseCode == 200) {
      statusApp = "Yes, it is working";
      } else {
        statusApp = "Sorry, Something wrong";
      }
      
      System.out.println("Status of the application: " + statusApp);
    } catch (MalformedURLException ex) {
      Logger.getLogger(URLHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(URLHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
