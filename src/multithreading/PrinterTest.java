package multithreading;

public class PrinterTest {

  public static void main(String[] args) {
    OddEvenPrinter odd = new OddEvenPrinter("Odd");
    OddEvenPrinter even = new OddEvenPrinter("Even");
    Thread oddThread = new Thread(odd);
    Thread evenThread = new Thread(even);
    oddThread.start();
    evenThread.start();
    
  }

}
