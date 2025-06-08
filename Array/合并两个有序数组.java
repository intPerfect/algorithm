package Array;

import java.util.*;

/**
 * @LeetCodeId 88
 * @LeetCodeLink <a href="https://leetcode.cn/problems/merge-sorted-array">合并两个有序数组</a>
 * @Date 2025-06-07
 */
public class 合并两个有序数组 {
    static class Solution {
        /**
         * 将两个有序数组合并到 nums1 中
         *
         * @param nums1 第一个数组，长度为 m + n，前 m 位为有效数据，后 n 位为占位 0
         * @param m     nums1 中有效数据的长度
         * @param nums2 第二个数组，长度为 n
         * @param n     nums2 的长度
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int tail = m + n - 1;
            int p1 = m - 1, p2 = n - 1;

            int cur;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] > nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int[] nums2_1 = {2, 5, 6};
        solution.merge(nums1_1, 3, nums2_1, 3);
        System.out.println(Arrays.toString(nums1_1)); // 输出: [1, 2, 2, 3, 5, 6]

        // 测试用例 2
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        solution.merge(nums1_2, 1, nums2_2, 0);
        System.out.println(Arrays.toString(nums1_2)); // 输出: [1]

        // 测试用例 3
        int[] nums1_3 = {0};
        int[] nums2_3 = {1};
        solution.merge(nums1_3, 0, nums2_3, 1);
        System.out.println(Arrays.toString(nums1_3)); // 输出: [1]
    }
}
