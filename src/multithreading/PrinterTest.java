package multithreading;

public class PrinterTest {

  public static void main(String[] args) {
    OddEvenPrinter odd = new OddEvenPrinter("Odd");
    OddEvenPrinter even = new OddEvenPrinter("Even");
    Thread oddThread = new Thread(odd);
    Thread evenThread = new Thread(even);
    oddThread.start();
    
    oddThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("Exception occurred in odd thread : " + t + ", message : " + e.getMessage());
		}
	});
    
    evenThread.start();
    evenThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("Exception occurred in even thread : " + t + ", message : " + e.getMessage());
		}
	});
    
  }

}
