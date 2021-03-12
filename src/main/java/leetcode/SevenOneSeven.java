package leetcode;

public class SevenOneSeven {

    public static void main(String[] args) {
        // 0
        // 10 11
        int[] bits = {1, 0, 0,1,1,1,0,1,0};
        int length = bits.length;
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        System.out.println( i == length - 1);

    }
}
