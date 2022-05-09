package thread;

import java.lang.String;
import java.util.Scanner;

public class TestInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().isInterrupted());
                Scanner sc = new Scanner(System.in);
                String next = sc.next();
                if("next".equals(next) && Thread.currentThread().isInterrupted()){
                    Thread.interrupted();
                }
            }
        });
        thread.start();


        Thread.sleep(1200);

        thread.interrupt();
    }
}
