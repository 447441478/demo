package lang;

public class TestNumber {
    private static int aa = 1;
    public static void main(String[] args) {
        System.out.println(equals(1, 1L));
        System.out.println(equals(1L));
    }


    public static boolean equals(Number num, Number num2){
        return num.equals(num2);
    }

    public static boolean equals(Long num){
        return aa == num;
    }
}
