package com.java.design.lrucache;

public class LRUCacheTest {

  public static void main(String[] args) {
    Cache cache = new LRUCache();
    cache.put("k1", 1);
    cache.put("k2", "Navneet");
    cache.put("k3", new int[]{1,2,4});
    System.out.println(cache.get("k3"));
  }

}
