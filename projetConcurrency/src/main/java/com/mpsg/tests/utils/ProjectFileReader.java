package com.mpsg.tests.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectFileReader {

  private ProjectFileReader() {}

  private static final Logger LOGGER = Logger.getLogger(ProjectFileReader.class.getName());

  public static List<String> getLinesFromFile(String urlFile) {
    List<String> list = new ArrayList<>();

    try {
      File file = new File(urlFile);
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      
      while ((line = reader.readLine()) != null) {
        list.add(line);
      }
      reader.close();
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "File not found", e);
    }
    return list;
  }
}
