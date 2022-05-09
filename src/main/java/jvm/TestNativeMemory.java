package jvm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -Xmn10m -XX:NativeMemoryTracking=summary -XX:MaxDirectMemorySize=20m -XX:+PrintGCDetails -XX:+UseG1GC
 * 禁用显示调用System.gc() 直接内存会oom
 * -XX:+DisableExplicitGC
 */
public class TestNativeMemory {

    public static void main(String[] args) throws IOException {

        List<ByteBuffer> directList = new ArrayList<>();
        List<ByteBuffer> list = new ArrayList<>();

        int gap = 1024;
        new Thread(()->{
            int count = 0;
            int size = 0;
            while (true){
                if (directList.size() >= 4) {
                    size--;
                    directList.remove(0);
                    System.out.println("remove");
                }
                System.out.println("size="+size);
                if (count++ % 10 == 0 && count != 1) {
                    System.out.println("input enter");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                directList.add(ByteBuffer.allocateDirect(1 << 21));
                size++;
            }
        }).start();
        while (true) {
            if (directList.size() >= 5) {
                directList.remove(0);
                System.out.println("remove");
            }
            if (list.size() >= gap) {
                for (int i = 0; i < gap; i++) {
                    list.remove(0);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            for (int i = 0; i < gap; i++) {
                list.add(ByteBuffer.allocate(1 << 10));
            }
        }

    }
}
