package leetcode;

public class TestLetCode {

    /**
     * @param nums
     * @descriptiom:移动零
     */
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            //当前元素不等于0时，放左边，否则放右边
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow++] = temp;
            }
        }
    }

    public void printEveryNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * @Description: 移动零并排序
     * @param nums
     */
    public void moveZeroesAndSort(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int slow = 0;
        // 使用计数排序思想，边移动边排序
        int[] count = new int[1001]; // 假设元素范围在0-1000之间
        int zeroCount = 0;
        
        // 统计每个非零元素的出现次数
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                count[num]++;
            }
        }
        
        // 重新填充数组，按递增顺序放置非零元素
        int index = 0;
        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
        
        // 将所有零元素放到数组末尾
        while (zeroCount > 0) {
            nums[index++] = 0;
            zeroCount--;
        }


    }

    public static void main(String[] args) {
        TestLetCode test = new TestLetCode();
        int[] nums = {0, 1, 0, 3, 12, 0, 4, 9};
        test.moveZeroes(nums);
        test.printEveryNum(nums);
    }


}
