package Algorithms;


/**
 * 冒泡排序
 */
public class BubbleSort {

    //从小到大
    public static void main(String[] args) {
        int[] sourceArray = {9, 243, 34, 21, 605, 46, 59, 89, 96};
        int arrLength = sourceArray.length;
        for (int k = 1; k < arrLength; k++) {
            for (int i = 0; i < arrLength - k; i++) {
                if (sourceArray[i+1] < sourceArray[i]) {
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[i+1];
                    sourceArray[i+1] = temp;
                }
            }
        }
        System.out.println(sourceArray);
    }

}


