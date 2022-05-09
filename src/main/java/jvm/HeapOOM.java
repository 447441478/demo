package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Arg -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    public static class OOMObject{}

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
