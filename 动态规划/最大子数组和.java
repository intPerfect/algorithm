package 动态规划;

import java.util.*;

/**
 * @LeetCodeId 53
 * @LeetCodeLink <a href="https://leetcode.cn/problems/maximum-subarray">最大子数组和</a>
 * @Date 2025/04/17
 */
public class 最大子数组和 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, max = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                max = Math.max(pre, max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("测试用例 1 输出：" + solution.maxSubArray(nums1)); // 6

        // 测试用例 2
        int[] nums2 = {1};
        System.out.println("测试用例 2 输出：" + solution.maxSubArray(nums2)); // 1

        // 测试用例 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("测试用例 3 输出：" + solution.maxSubArray(nums3)); // 23
    }
}
