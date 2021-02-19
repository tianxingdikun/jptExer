package Algorithms;

/**
 * 选择排序
 *
 * 两层循环
 * 第一层循环，假设当前值是最小值，记录下标；
 * 第二层循环，在第一层的的基础上往后走，比较最小值与当前下标对应值，如果小于则替换最小值（把下标
 *      给min），在第一层循环里做交换；
 *
 *
 * 每次都把最小值提到最左边
 *
 */
public class SelectSort {

    //从小到大
    public static void main(String[] args) {
        int[] sourceArr = {98,83,26,30,665,965};
        int arrLength  = sourceArr.length;
        for (int k = 0; k < arrLength-1; k++) {
            int min = k;
            for (int i = k + 1; i < arrLength - 1; i++) {
                if (sourceArr[i] < sourceArr[min]) {
                    min = i;
                }
            }
            if (k != min) {
                int temp = sourceArr[min];
                sourceArr[min] = sourceArr[k];
                sourceArr[k] = temp;
            }
        }
        System.out.println(sourceArr);
    }

}
