package com.mpsg.dao;

import java.util.List;

public interface CrudDao<T, V> {

  public V save(T object);

  public List<T> getAll();

  public T getById(V id);

  public V deleteAll();

  public V delete(T object);
}
