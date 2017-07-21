package com.java.design.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache implements Cache{
  private final String NOT_FOUND = "NOT_FOUND";
  private final String OK = "OK";
  Map<String, Object> keyValuePair;
  LinkedList<Object> lruList; 
  
  public LRUCache(){
    lruList = new LinkedList<>();
    keyValuePair = new HashMap<>();
  }
  
  @Override
  public Object get(Object key) {
    if(keyValuePair.containsKey(key)){
      Object node = keyValuePair.get(key);
      lruList.remove(node);
      lruList.addFirst(node);
      return keyValuePair.get(key);
    }
    return null;
  }

  @Override
  public void put(String key, Object value) {
    if(keyValuePair.containsKey(key)){
      lruList.remove(value);
    }
    
    keyValuePair.put(key, value);
    lruList.addFirst(value);
  }

  @Override
  public void delete(String key) {
    if(keyValuePair.containsKey(key)){
      Object node = keyValuePair.get(key);
      keyValuePair.remove(key);
      lruList.remove(node);
      System.out.println(OK);
    }else{
      System.out.println(NOT_FOUND);
    }
    
  }

  @Override
  public boolean contains(String key) {
    if(keyValuePair.containsKey(key))
      return true;
    return false;
  }
  
}
