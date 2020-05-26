package com.mpsg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mpsg.beans.User;
import com.mpsg.beans.UserBuilder;

public class UserDao implements CrudDao<User, Integer> {

  private final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

  enum UserTable {
    ID(1),
    NAME(2),
    EMAIL(3);

    private int value;

    private UserTable(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  @Override
  public Integer save(User user) {
    PreparedStatement statement;
    Connection connection = DataBaseConnection.getConnection();
    int row = 0;
    try {
      statement = connection.prepareStatement("insert into user values(?,?,?)");
      statement.setInt(UserTable.ID.getValue(), user.getId());
      statement.setString(UserTable.NAME.getValue(), user.getName());
      statement.setString(UserTable.EMAIL.getValue(), user.getEmailAddress());
      row = statement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.log(Level.SEVERE, null, e);
    } finally {
      DataBaseConnection.closeConnection(connection);
    }
    return row;
  }

  @Override
  public Integer deleteAll() {
    PreparedStatement statement;
    Connection connection = DataBaseConnection.getConnection();
    int row = 0;
    try {
      statement = connection.prepareStatement("delete from user");
      row = statement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.log(Level.SEVERE, null, e);
    } finally {
      DataBaseConnection.closeConnection(connection);
    }
    return row;
  }

  @Override
  public Integer delete(User user) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<User> getAll() {
    PreparedStatement statement;
    Connection connection = DataBaseConnection.getConnection();
    List<User> list = new ArrayList<>();

    try {
      statement = connection.prepareStatement("select * from user");
      ResultSet rs = statement.executeQuery();
      
      while (rs.next()) {
        list.add(new UserBuilder().setId(rs.getInt("id")).setName(rs.getString("name"))
            .setEmailAddress(rs.getString("emailAddress")).buildUser());
      }
    } catch (SQLException e) {
      LOGGER.log(Level.SEVERE, null, e);
    } finally {
      DataBaseConnection.closeConnection(connection);
    }
    return list;
  }

  @Override
  public User getById(Integer id) {
    // TODO Auto-generated method stub
    return null;
  }


}
