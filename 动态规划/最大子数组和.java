package 动态规划;

/**
 * @LeetCodeId 53
 * @LeetCodeLink <a href="https://leetcode.cn/problems/maximum-subarray">最大子数组和</a>
 * @Frequency 🔥🔥🔥
 * @Date 2025/04/17
 */
public class 最大子数组和 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;

            // dp[i]：以 nums[i] 结尾的最大子数组和
            int[] dp = new int[n];
            dp[0] = nums[0];
            int res = dp[0];

            for (int i = 1; i < n; i++) {
                // 只有两种状态转移情况：
                // ① 将 nums[i] 加入前面的子数组
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    // 前面的子数组和为负数，已经没有意义了，因此：
                    // ② 从 nums[i] 开始一个新的子数组
                    dp[i] = nums[i];
                }
                res = Math.max(res, dp[i]);
            }
            return res;
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
