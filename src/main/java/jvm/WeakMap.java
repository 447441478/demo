package jvm;

import java.util.WeakHashMap;

public class WeakMap {

    public static void main(String[] args) {
        WeakHashMap<Key, Val> map = new WeakHashMap<>();
        Key key = new Key();
        //Key key2 = new Key();
        map.put(key, null);
        map.put(new Key(), null);
        map.put(new Key(), null);
        map.entrySet().forEach((entry)->{
            System.out.println("key="+entry.getKey());
        });
        System.out.println();
        System.out.println();
        System.out.printf("map.size=%s\n", map.size());
        System.gc();
        System.out.printf("map.size=%s\n", map.size());
       /* map.entrySet().forEach((entry)->{
            System.out.println("key="+entry.getKey());
        });*/
        System.out.printf("map.size=%s\n", map.size());
    }

    static class Key{
        byte[] size = new  byte[1<<20];// 1M
    }
    static class Val{
        byte[] size = new  byte[1<<20];// 1M
    }
}
