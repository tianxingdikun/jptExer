package Algorithms;

import java.util.Scanner;

/**
 * n皇后问题-回溯法
 */
public class Nqueen {

    static int max = 8;      //8皇后
    static int[] array = new int[max];   //每一行棋子所在的列数，下标即为行数
    public static int count = 0;  //可能性

    public static void main1(String[] args) {
        Check(0);
        System.out.println(count);
    }

    public static void Check(int n) {
        if (n == max) {
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (JudgeIsOk(n)) {
                Check(n + 1);
            }
        }
    }

    public static boolean JudgeIsOk(int n) {
        //判断是否在同一列、同一行、或者同一对角线
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || (n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }


    static int N;
    static int[] position;

    //用来存放算好的皇后位置。最左上角是(0,0)
    public static void NQueen(int k) {
        //在0~k-1行皇后已经摆好的情况下，摆第k行及其后的皇后
        if (k == N) {
            // N 个皇后已经摆好
            System.out.print(position[0] + 1);
            for (int i = 1; i < N; i++) {
                System.out.print(" " + (position[i] + 1));
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                //逐尝试第k个皇后的位置
                int j;
                for (j = 0; j < k; j++) {
                    //和已经摆好的 k 个皇后的位置比较，看是否冲突
                    if (position[j] == i || Math.abs(position[j] - i) == Math.abs(k - j)) {
                        break;//冲突，则试下一个位置
                    }
                }
                if (j == k) {
                    //当前选的位置 i 不冲突
                    position[j] = i;//将第k个皇后摆放在位置 i
                    NQueen(k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        position = new int[N];
        NQueen(0);//从第0行开始摆皇后
        in.close();
    }

}
