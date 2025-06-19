package 动态规划;

/**
 * @LeetCodeId 5
 * @LeetCodeLink <a href="https://leetcode.cn/problems/longest-palindromic-substring">最长回文子串</a>
 * @Frequency 288
 * @Date 2025-05-28
 */
public class LongestPalindromicSubstring {
    static class Solution {
        /**
         * 动态规划解法，寻找字符串中最长的回文子串
         *
         * @param s 输入字符串
         * @return 最长回文子串
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }

            int len = s.length();
            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = 0;

            // dp[l][r] 表示 s[l...r] 是否为回文子串
            boolean[][] dp = new boolean[len][len];

            for (int r = 1; r < len; r++) {
                for (int l = 0; l < r; l++) {
                    // dp[l][r] = (s[l] == s[r]) && dp[l + 1,r - 1]
                    if (s.charAt(l) == s.charAt(r)) {
                        if (r - l <= 2 || dp[l + 1][r - 1]) {
                            dp[l][r] = true;
                            // 更新答案
                            int curLen = r - l + 1;
                            if (curLen > maxLen) {
                                maxLen = curLen;
                                maxStart = l;
                                maxEnd = r;
                            }
                        }
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("输入: babad -> 输出: " + solution.longestPalindrome("babad"));
        System.out.println("输入: cbbd  -> 输出: " + solution.longestPalindrome("cbbd"));
        System.out.println("输入: a     -> 输出: " + solution.longestPalindrome("a"));
        System.out.println("输入: ac    -> 输出: " + solution.longestPalindrome("ac"));
    }

}

