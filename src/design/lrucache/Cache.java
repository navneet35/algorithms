package design.lrucache;

public interface Cache {
  public Object get(Object key);
  public void put(String key, Object value);
  public void delete(String key);
  public boolean contains(String key);
}
