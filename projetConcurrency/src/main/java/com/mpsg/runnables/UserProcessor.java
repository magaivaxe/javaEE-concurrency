package com.mpsg.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.Constants;
import com.mpsg.beans.UserBuilder;
import com.mpsg.dao.UserDao;

public class UserProcessor implements Callable<Integer> {

  private String userRecord;
  private UserDao dao;
  private final Logger LOGGER = Logger.getLogger(UserProcessor.class.getName());

  public UserProcessor(String userRecord, UserDao dao) {
    super();
    this.userRecord = userRecord;
    this.dao = dao;
  }

  @Override
  public Integer call() throws Exception {
    StringTokenizer tokenizer = new StringTokenizer(userRecord, Constants.DELIMITER.getValue());
    int rows = 0;

    LOGGER.log(Level.INFO, Thread.currentThread().getName() + " processing record for: " + userRecord);

    while (tokenizer.hasMoreTokens()) {
      rows = dao.save(new UserBuilder().setEmailAddress(tokenizer.nextToken()).setName(tokenizer.nextToken())
          .setId(Integer.valueOf(tokenizer.nextToken())).buildUser());
    }
    return rows;
  }

  public String getUserRecord() {
    return userRecord;
  }

  public void setUserRecord(String userRecord) {
    this.userRecord = userRecord;
  }

  public UserDao getDao() {
    return dao;
  }

  public void setDao(UserDao dao) {
    this.dao = dao;
  }

}
