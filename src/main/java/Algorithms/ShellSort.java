package Algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 希尔排序
 * <p>
 * 确定步长，步长两端相互比较，以递增方式放置
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] sourceArr = {56, 76, 23, 2, 866, 778, 367};
        int arrLength = sourceArr.length;
        int h = 1;
        while (h < arrLength / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < arrLength - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (sourceArr[j] < sourceArr[j - h]) {
                        int temp = sourceArr[j];
                        sourceArr[j] = sourceArr[j - h];
                        sourceArr[j - h] = temp;
                    }
                }
            }
        }
        System.out.println(sourceArr);
    }
}
