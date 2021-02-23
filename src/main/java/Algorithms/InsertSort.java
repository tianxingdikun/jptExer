package Algorithms;

/**
 * 插入排序
 *
 * 假设第一个数有序（作为段1），第二个数往后无序（作为段2），开始遍历段2，
 * 以段2开始的数作为要插入的数，跟段1中从右到左比较，进行插入。
 *
 *
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class InsertSort {

    //从小到大
    public static void main(String[] args) {
        int[] sourceArr = {89, 136, 148, 79, 589, 670, 9};
        int arrLength = sourceArr.length;
        //k以第二个数为开始
        for (int k = 1; k < arrLength; k++) {
            //要插入的数
            int temp = sourceArr[k];
            int i = k;
            //跟段1从右到左比较，游标i减少
            while (i > 0 && temp < sourceArr[i - 1]) {
                sourceArr[i] = sourceArr[i - 1];
                i--;
            }
            //插入到段1中的适当位置
            if (i != k) {
                sourceArr[i] = temp;
            }
        }
        System.out.println(sourceArr);


    }

}
