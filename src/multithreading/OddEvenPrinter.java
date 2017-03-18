package multithreading;

public class OddEvenPrinter implements Runnable {
  private String name;
  private int maxLimit = 10;
  private static boolean isOddPrinted = false;
  public static final Object lock = "s";
  public static int counter  = 1;
  
  public OddEvenPrinter(String name) {
    this.setName(name);
    System.out.println("Thread Created with name : " + name);
  }
  
  @Override
  public void run() {
    System.out.println("thread running " + name);
    try {
      while(counter < maxLimit){
        if(this.name.equals("Odd")){
          printOdd();
        }else{
          printEven();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    throw new RuntimeException("Test Exception");
  }
  
 /* public static synchronized void printOdd() throws InterruptedException{
    System.out.println("In odd method");
      if(isOddPrinted)
        OddEvenPrinter.class.wait();
      System.out.println(Thread.currentThread().getName() + " printed value " + counter);
      isOddPrinted = true;
      counter++;
      OddEvenPrinter.class.notify();      
  }

  public static synchronized void printEven() throws InterruptedException{
    System.out.println("In even method");
      if(!isOddPrinted)
        OddEvenPrinter.class.wait();
      System.out.println(Thread.currentThread().getName() + " printed value " + counter);
      isOddPrinted = false;
      counter++;
      OddEvenPrinter.class.notify();
  }*/
  
  public void printOdd() throws InterruptedException{
	  synchronized (lock) {
		  System.out.println("In odd method");
	      if(isOddPrinted)
	        lock.wait();
	      System.out.println(this.getName() + " printed value " + counter);
	      isOddPrinted = true;
	      counter++;
	      lock.notify();
	  }
  }

  public void printEven() throws InterruptedException{
	  synchronized (lock) {
		  System.out.println("In even method");
	      if(!isOddPrinted)
	        lock.wait();
	      System.out.println(this.getName() + " printed value " + counter);
	      isOddPrinted = false;
	      counter++;
	      lock.notify();
	    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
