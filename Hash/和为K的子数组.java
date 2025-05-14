package Hash;

import java.util.*;

/**
 * @LeetCodeId 560
 * @LeetCodeLink <a href="https://leetcode.cn/problems/subarray-sum-equals-k">和为 K 的子数组</a>
 * @Date 2025-05-13
 */
public class 和为K的子数组 {
    static class Solution {

        public int subarraySum(int[] nums, int k) {
            int count = 0;
            // 前缀和 pre --> 出现次数 n
            HashMap<Integer, Integer> map = new HashMap<>();

            // 前缀和0 --> 出现1次
            int pre = 0;
            map.put(0, 1);

            for (int num : nums) {
                pre += num;
                // 能够在之前的记录中找到 n 个前缀和等于 pre - k 的，
                if (map.containsKey(pre - k)) {
                    // 可以和当前前缀和 pre 一起，构成 n 个和为 k 的子数组
                    count += map.get(pre - k);
                }
                // 前缀和为 pre 的出现次数 n += 1
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("测试用例 1 输出: " + solution.subarraySum(nums1, k1)); // 预期输出：2

        // 测试用例 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("测试用例 2 输出: " + solution.subarraySum(nums2, k2)); // 预期输出：2

        // 测试用例 3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("测试用例 3 输出: " + solution.subarraySum(nums3, k3)); // 预期输出：3
    }
}

