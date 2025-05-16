package 贪心算法;

import java.util.*;

/**
 * @LeetCodeId 121
 * @LeetCodeLink <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock">买卖股票的最佳时机</a>
 * @Frequency 🔥🔥🔥
 * @Date 2025-05-16
 */
public class 买卖股票的最佳时机 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    // 记录迄今为止的最低价格
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    // 贪心算法，走一步更新一次最大利润
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("最大利润: " + solution.maxProfit(prices1)); // 输出: 5

        // 测试用例 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("最大利润: " + solution.maxProfit(prices2)); // 输出: 0
    }
}

