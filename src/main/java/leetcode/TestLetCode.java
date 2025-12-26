package leetcode;


import bo.ListNode;
import bo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("subarraySum: " + res);
        return res;
    }

    /**
     * @param head
     * @return
     * @Description: 链表两两交换
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

    /**
     * @param head
     * @param k
     * @return
     * @Description: K个一组翻转链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        ListNode newHead = reverse(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }


    /**
     * @param nums
     * @return
     * @Description: 数组中挑选三数之和为0的所有数组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length -2 ; k++) {
            if (nums[k] > 0) {
                break;
            }
            int i = k + 1, j = nums.length - 1, sum;
            if (k > 0 && nums[k] == nums[k-1]) continue;
            while (i < j) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        System.out.println("threeSum: " + res);
        return res;
    }

    /**
     * @Description: 二叉树先序遍历(用递归)
     * @param root
     */
    public void preOrderWithDepth(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        preOrderWithDepth(root.left);
        preOrderWithDepth(root.right);
    }

    /**
     * @Description: 二叉树先序遍历(用栈)
     * @param root
     */
    public void preOrderWithStack(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
                System.out.println(root.val);
            }
            root = stack.pop();
            root = root.right;
        }
    }

    /**
     * @Description: 二叉树展开为链表,顺序如先序遍历；如O(1)更好
     * @param root
     */
    public void flatten(TreeNode root) {
        //用栈Stack存储节点
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = pop;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            pre = pop;
        }
    }

    /**
     * @Description: 矩阵中单词搜索
     * 使用回溯法:
     * 1、确定搜索的起点，即矩阵中字符的第一个字符；
     * 2、确定搜索的终点，即矩阵中字符的最后一个字符；
     * 3、确定搜索的规则，即从当前节点开始，向上下左右四个方向搜索，搜索到单词中的按顺序字符则继续搜索，搜索到字符的终点则返回true，搜索到字符的终点则返回false；
     * 4、剪枝（记得每次恢复原值）：
     * 5、递归：
     * 6、返回结果：
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
               if (dfsAndCut(board,chars,m,n,0)) {
                   return true;
               }
            }
        }
        return false;
    }

    public boolean dfsAndCut(char[][] board, char[] chars, int m,int n,int k) {
        if (m >= board.length || m < 0 || n >= board[0].length || n < 0 || board[m][n] != chars[k]) return false;
        if (k == chars.length - 1) return true;
        //占位符，标志已访问过，剪枝
        board[m][n] = ' ';
        boolean res = dfsAndCut(board,chars,m,n + 1, k + 1) || dfsAndCut(board, chars, m+1,n,k+1)
                || dfsAndCut(board,chars,m,n-1,k+1) || dfsAndCut(board,chars,m-1,n,k+1);
        //剪枝后递归，递归后恢复原值，便于下一次处理
        board[m][n] = chars[k];
        return res;
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

//        letCode.subarraySum(nums, 3);

        int[] threeNum = {-1, 0, 1, 2, -1, -4};
        letCode.threeSum(threeNum);

    }


}
