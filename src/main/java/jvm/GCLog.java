package jvm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * VM Arg -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps
 */
public class GCLog {
    private static final int _1M = 1 << 20;

    public static void main(String[] args) throws InterruptedException {
       // System.out.println(_1M);
        byte[] byte1 = new byte[2 * _1M];
        byte[] byte2 = new byte[2 * _1M];
        byte[] byte4 = new byte[5 * _1M];
        byte[] byte6 = new byte[5 * _1M];
        Thread.sleep(5000);
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println();
        byte[] byte3 = new byte[1 * _1M-1];
        System.out.println("end");
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int first = 0;
        while(first < num.length-2){
            if(num[first] > 0) {
                break;
            }
            int second = first+1;
            int third = num.length-1;
            if(num[first] == num[second] || num[second] == num[third]){
                first++;
                continue;
            }
            int sum = num[first] + num[second] + num[third];
            if(sum > 0){
                third--;
            }else if(sum < 0){
                second++;
            }else{
                ans.add(new ArrayList<>(Arrays.asList(num[first], num[second], num[third])));
            }

            first++;
        }
        return ans;
    }
}
