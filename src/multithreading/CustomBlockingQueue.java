package multithreading;

public interface CustomBlockingQueue<E> {
  void put(E item) throws InterruptedException;
  E take() throws InterruptedException;
  int size();
}
