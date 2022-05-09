package jvm;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    static class MyData {
        int number = 0;

         void setTo60(){
            this.number = 60;
        }

        void addPlusPlus(){
             number ++;
        }

        void addCAS(){
             while (true){
                 int temp = number;
                 int result = temp + 1;
                 synchronized(this){
                     if(temp == number){
                         number = result;
                         break;
                     }
                 }

             }
        }
    }

    public static void main(String[] args) {
        testSee();
    }

    private static void TestCAS() {
        MyData myData = new MyData();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    //myData.addPlusPlus();
                    myData.addCAS();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("over number="+myData.number);
    }

    /**
     * 测试可见性
     */
    private static void testSee() {
        MyData myData = new MyData();

        new Thread(()->{
            String name = Thread.currentThread().getName();
            System.out.println(name+" come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.setTo60();
            System.out.println(name + " now number:"+myData.number);

        }, "AAA").start();

        while (myData.number == 0){
            System.out.println("11");
        }
        System.out.println("main over");
    }
}
