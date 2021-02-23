package Algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 希尔排序
 * <p>
 * 确定步长，步长两端相互比较，以递增方式放置,
 * 步长在条件循环中会调整
 *
 * 时间复杂度：
 * 空间复杂度：
 *
 * 步长的使用没有理解
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {56, 76, 23, 2, 866, 778, 367};
        int arrLength = arr.length;
        int gap = 1;
        while (gap < arrLength / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arrLength; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        System.out.println(arr);
    }
}
