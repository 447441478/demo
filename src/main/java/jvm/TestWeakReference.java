package jvm;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class TestWeakReference {
    static WeakHashMap<Thread, WeakReference<Val>> cache = new WeakHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        cache.put(Thread.currentThread(), new WeakReference(new Val(1)));

        new Thread(()->aaa()).start();
        new Thread(()->aaa()).start();
        TimeUnit.SECONDS.sleep(1);
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("threadCount="+Thread.activeCount());
        System.out.println("cache.size="+cache.size());

    }

    public static void aaa(){
        gen();
        Val val = cache.get(Thread.currentThread()).get();
        System.gc();
        System.out.println("aaa="+val);
        bbb();
        System.out.println(cache.size());
    }
    public static void bbb(){
        Val val = cache.get(Thread.currentThread()).get();
        System.out.println("bbb"+val);
    }

    public static void gen(){
        if(cache.get(Thread.currentThread()) == null){
            cache.put(Thread.currentThread(), new WeakReference(new Val(Thread.currentThread().getId())));
        }
    }

    static class Val{
        private long val;

        public Val(long val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Val{" +
                    "val=" + val +
                    '}';
        }
    }
}
