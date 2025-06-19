package Array;

import java.util.*;

/**
 * @LeetCodeId 238
 * @LeetCodeLink <a href="https://leetcode.cn/problems/product-of-array-except-self">除自身以外数组的乘积</a>
 * @Date 2025-06-19
 */
public class 除自身以外数组的乘积 {
    static class Solution {
        /**
         * 返回一个数组 answer，使得 answer[i] 是 nums 中除 nums[i] 以外所有元素的乘积。
         * 不使用除法，时间复杂度为 O(n)。
         *
         * @param nums 输入整数数组
         * @return 结果数组
         */
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] left = new int[len];   // (前缀积) left[i] 表示 nums[0..i-1] 的乘积
            int[] right = new int[len];  // (后缀积) right[i] 表示 nums[i+1..len-1] 的乘积
            int[] res = new int[len];    // 最终结果数组

            left[0] = 1;                 // 左边没有元素，乘积为1
            right[len - 1] = 1;          // 右边没有元素，乘积为1

            // 构建左乘积数组
            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * nums[i - 1];
            }

            // 构建右乘积数组
            for (int i = len - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i + 1];
            }

            // 结果为左乘积 * 右乘积
            for (int i = 0; i < len; i++) {
                res[i] = left[i] * right[i];
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums1))); // 预期输出: [24, 12, 8, 6]

        // 测试用例 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums2))); // 预期输出: [0, 0, 9, 0, 0]

        // 测试用例 3
        int[] nums3 = {5, 0, 2};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums3))); // 预期输出: [0, 10, 0]
    }
}
