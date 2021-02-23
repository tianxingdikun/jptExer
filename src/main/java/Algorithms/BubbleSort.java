package Algorithms;


import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 两次嵌套遍历：
 * 1、第一次遍历，选定第一个数，跟相邻比较，数大的交换位置往后挪；
 * 2、第二次遍历，重复操作1，比较的终点是上一次排好的结束位置。
 *
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 *
 */
public class BubbleSort {

    //从小到大
    public static void main(String[] args) {
        int[] sourceArray = {9, 243, 34, 21, 605, 46, 59, 89, 96};
        int arrLength = sourceArray.length;
        for (int k = 1; k < arrLength; k++) {
            for (int i = 0; i < arrLength - k; i++) {
                if (sourceArray[i + 1] < sourceArray[i]) {
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[i + 1];
                    sourceArray[i + 1] = temp;
                }
            }
        }
        System.out.println(sourceArray);
    }


}


