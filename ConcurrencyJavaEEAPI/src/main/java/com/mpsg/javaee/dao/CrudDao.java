package com.mpsg.javaee.dao;

import java.util.List;

public interface CrudDao<T, V> {
  
  public List<T> getAll();
  
  public T getById(V v);
  
  public V delete(V v);
  
  public V set(T t);
}
