package volatile_;

import java.lang.String;

public class TestVolatile {

    boolean run = true;
    volatile int s = 1;
    // -Xint
    public static void main(String[] args) {

        TestVolatile v = new TestVolatile();
        //thread 1
        new Thread(() ->{
            while (v.run) {
               
                //int a = v.s;    //如果不注释这行，线程1无法中止
            }
        }).start();
        //thread 2
        new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            v.run = false;
            System.out.println("set run false");
        }).start();
    }
}
