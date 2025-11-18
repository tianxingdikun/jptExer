package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestLetCode {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

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
     * @param nums
     * @Description: 移动零并排序
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

    /**
     * @param nums
     * @Description: 最长连续序列个数
     */
    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int next = num + 1;
            while (set.contains(next)) {
                next++;
            }
            res = Math.max(res, next - num);
        }
        System.out.println("longestConsecutive: " + res);
        return res;
    }

    /**
     * @param nums
     * @Description: /**
     * @Description: 最长连续序列
     * 要求计算出最长连续序列的长度，且打印出该序列的具体内容。
     * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive sequence is [1, 2, 3, 4]
     * and its length is 4.
     */
    public int printLongestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int start = 0; // Track the start of the longest sequence
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentStart = num;
            int next = num + 1;
            while (set.contains(next)) {
                next++;
            }
            int length = next - num;
            if (length > res) {
                res = length;
                start = currentStart;
            }
        }
        // Print the longest consecutive sequence
        System.out.print("Longest consecutive sequence: [");
        for (int i = 0; i < res; i++) {
            System.out.print(start + i);
            if (i < res - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Length: " + res);
        return res;
    }

    /**
     * @param height
     * @Description: 盛最多水的容器
     */
    public int maxArea(int[] height) {
        if (null == height || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    /**
     * @param s
     * @Description: 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println("lengthOfLongestSubstring: " + res);
        return res;
    }

    /**
     * @param nums
     * @param k
     * @Description: 和为k的子数组
     */
    public int subarraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0) return 0;
        int res = 0;
        //<子数组之和，子数组元素个数>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println("subarraySum: " + res);
        return res;
    }

    /**
     * @Description: 链表两两交换
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return head;

    }



    public static void main(String[] args) {
        TestLetCode letCode = new TestLetCode();
        int[] nums = {0, 1, 0, 3, 12, 0, 4, 9, 2};
//        test.moveZeroes(nums);
//        test.printEveryNum(nums);

//        letCode.longestConsecutive(nums);
//        letCode.printLongestConsecutive(nums);

//        String s = "abcabcbb";
//        letCode.lengthOfLongestSubstring(s);

        letCode.subarraySum(nums,3);

    }


}
