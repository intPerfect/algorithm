package 二分查找;

import java.util.*;

/**
 * @LeetCodeId 33
 * @LeetCodeLink <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array">搜索旋转排序数组</a>
 * @Date 2025/07/18
 */
public class 搜索旋转排序数组 {
    static class Solution {
        // nums 在预先未知的某个下标 k 上进行了旋转
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) return -1;
            if (n == 1) return nums[0] == target ? 0 : -1;

            int left = 0, right = n - 1;
            // [left, right]
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) return mid;

                // 左右两个递增区间 分别二分查找
                // [left, mid] ↑
                if (nums[left] <= nums[mid]) {
                    // target 在 [left, mid] 区间内
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    // [mid, right] ↑
                } else {
                    // target 在 [mid, right] 区间内
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(solution.search(nums1, target1)); // 输出: 4

        // 测试用例 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(solution.search(nums2, target2)); // 输出: -1

        // 测试用例 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(solution.search(nums3, target3)); // 输出: -1
    }
}
