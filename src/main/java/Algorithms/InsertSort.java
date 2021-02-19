package Algorithms;

/**
 * 插入排序
 *
 *
 */
public class InsertSort {

    //从小到大
    public static void main(String[] args) {
        int[] sourceArr = {89,136,148,79,589,670,9};
        int arrLength = sourceArr.length;
        for (int k = 1; k < arrLength; k++) {
            int temp = sourceArr[k];
            int i = k;
            while (i > 0 && temp < sourceArr[i - 1]) {
                sourceArr[i] = sourceArr[i-1];
                i--;
            }
            if (i != k) {
                sourceArr[i] = temp;
            }
        }
        System.out.println(sourceArr);



    }

}
