package dp;

/**
 * @LeetCodeId 70
 * @LeetCodeLink <a href="https://leetcode.cn/problems/climbing-stairs/">爬楼梯</a>
 * @Date 2025-04-17
 */
public class 爬楼梯 {
    static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;

            // 1. dp[i]：爬到第 i 阶有 dp[i] 种方法
            int[] dp = new int[n + 1];
            // 2. 初始化
            dp[1] = 1; // 爬到第 1 阶有 1 种方法（+1）
            dp[2] = 2; // 爬到第 2 阶有 2 种方法（+1 +1, +2）
            for (int i = 3; i <= n; i++) {
                // 3. 状态转移方程：爬到第 i 阶有 dp[i] = dp[i-1] + dp[i-2] 种方法
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int n1 = 2;
        System.out.println("输入: " + n1 + " 输出: " + solution.climbStairs(n1)); // 输出: 2

        // 测试用例 2
        int n2 = 3;
        System.out.println("输入: " + n2 + " 输出: " + solution.climbStairs(n2)); // 输出: 3

        // 测试用例 3
        int n3 = 5;
        System.out.println("输入: " + n3 + " 输出: " + solution.climbStairs(n3)); // 输出: 8
    }
}
