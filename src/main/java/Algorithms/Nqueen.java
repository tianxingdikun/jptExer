package Algorithms;

/**
 * n皇后问题-回溯法
 */
public class Nqueen {

    int max = 8;      //8皇后
    int[] array = new int[max];   //每一行棋子所在的列数，下标即为行数
    public static int count = 0;  //可能性

    public static void main(String[] args) {
        new Nqueen().Check(0);
        System.out.println(count);
    }

    public void Check(int n) {
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

    public boolean JudgeIsOk(int n) {
        //判断是否在同一列、同一行、或者同一对角线
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || (n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

}
