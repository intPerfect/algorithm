package Array;

import java.util.*;

/**
 * @LeetCodeId 189
 * @LeetCodeLink <a href="https://leetcode.cn/problems/rotate-array">轮转数组</a>
 * @Date 2025-06-19
 */
public class 轮转数组 {
    static class Solution {
        /**
         * 将数组向右轮转 k 个位置，原地修改数组
         * <p>
         * nums = "----->-->"; k = 3
         * res = "-->----->";
         * <p>
         * reverse "----->-->" we can get "<--<-----"
         * reverse "<--" we can get "--><-----"
         * reverse "<-----" we can get "-->----->"
         *
         * @param nums 要轮转的整数数组
         * @param k    轮转的步数
         */
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k %= nums.length; // 如果k超过数组长度，取模避免多余轮转

            reverse(nums, 0, len - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, len - 1);
        }

        /**
         * 反转数组中从 start 到 end 的部分
         */
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1)); // 预期输出: [5, 6, 7, 1, 2, 3, 4]

        // 测试用例 2
        int[] nums2 = {-1, -100, 3, 99};
        solution.rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2)); // 预期输出: [3, 99, -1, -100]

        // 测试用例 3
        int[] nums3 = {1};
        solution.rotate(nums3, 0);
        System.out.println(Arrays.toString(nums3)); // 预期输出: [1]
    }
}
