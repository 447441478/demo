package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class TestPhantomReferce {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);
        Reference<?> reference;
        object = null;

        System.gc();
        System.out.println(referenceQueue.poll());
        while ((reference = referenceQueue.poll()) != null) {
            if (reference.equals(phantomReference)) {
                System.out.println("被回收了");
            }else{
                System.out.println(reference);
            }
        }
    }
}
