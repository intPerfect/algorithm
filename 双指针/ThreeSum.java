package 双指针;

import java.util.*;

/**
 * @LeetCodeId 15
 * @LeetCodeLink <a href="https://leetcode.cn/problems/3sum">三数之和</a>
 * @Frequency 411
 * @Date 2025-05-14
 */
public class ThreeSum {
    static class Solution {

        /**
         * 查找所有和为 0 的三元组，结果不重复
         *
         * @param nums 输入整数数组
         * @return 所有满足条件的三元组列表
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len < 3) return res;

            Arrays.sort(nums); // 排序数组

            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) break; // 当前数大于 0，后续不可能和为 0，直接跳出

                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重，跳过相同的起始数

                int L = i + 1;
                int R = len - 1;

                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++; // 左指针去重
                        while (L < R && nums[R] == nums[R - 1]) R--; // 右指针去重
                        L++; R--;
                    }
                    else if (sum < 0) L++;
                    else if (sum > 0) R--;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1)); // 输出: [[-1, -1, 2], [-1, 0, 1]]

        // 测试用例 2
        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2)); // 输出: []

        // 测试用例 3
        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3)); // 输出: [[0, 0, 0]]
    }
}

