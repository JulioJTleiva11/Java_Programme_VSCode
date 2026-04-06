package op03Exercises;



public class CounterThread extends Thread {
  
  int cnt = 0;

  public void run()
  {
    while (true) {
      if (isInterrupted()) {
        break;
      }
      printLine(++cnt);
    }
  }

  private void printLine(int cnt)
  {
    //Zeile ausgeben
    System.out.print(cnt + ": ");
    for (int i = 0; i < 30; ++i) {
      System.out.print(i == cnt % 30 ? "* " : ". ");
    }
    System.out.println();
    
    //100 ms. warten
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      interrupt();
    }
  }

  public static void main(String[] args)
  {
    CounterThread th = new CounterThread();
    {
      //Thread starten
      th.start();
      //2 Sekunden warten
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
      }
      //Thread unterbrechen
      th.interrupt();
    }
  }
}