package String;

import java.util.ArrayList;
import java.util.List;

public class regularExpression {

    public static void main(String[] args) {
        /**
         * -?
         * \d
         * \\
         * \\\\
         * \n\t
         *-?\\d+
         *
         *
         *
         */

        String a = "-1234";
        String b = "";
        String c = "";
        String d = "";
        System.out.println(a.matches("-?\\\\d+"));


        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = nums[0];
        int pre = 0;
        int cur;
        for (int num : nums) {
            cur = num;
            if (pre > 0) {
                cur += pre;
            }
            if (cur > max) {
                max = cur;
            }
            pre = cur;
        }
        System.out.println(max);


        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> list = new ArrayList<>();
        int max1 = candies[0];
        for (int candy : candies) {
            if (max1 < candy) {
                max1 = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies > max1) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
        }
    }
}
