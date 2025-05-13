package SlidingWindow;

import java.util.*;

/**
 * @LeetCodeId 3
 * @LeetCodeLink <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">无重复字符的最长子串</a>
 * @Date 2025-05-09
 */
public class 无重复字符的最长子串 {
    static class Solution {
        /**
         * 使用滑动窗口算法，找出字符串中不含重复字符的最长子串的长度。
         *
         * @param s 输入字符串
         * @return 最长不含重复字符的子串的长度
         */
        public int lengthOfLongestSubstring(String s) {
            // 使用 Set 维护当前窗口中的字符
            Set<Character> window = new HashSet<>();
            int res = 0;

            for (int left = 0,right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                // 如果当前字符已在窗口中，移动左边界直到移除重复字符
                while (window.contains(c)) {
                    window.remove(s.charAt(left));
                    left++;
                }
                // 将当前字符加入窗口
                window.add(c);
                // 更新最大长度
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String s1 = "abcabcbb";
        System.out.println("输入: " + s1 + "，输出: " + solution.lengthOfLongestSubstring(s1)); // 3

        // 测试用例 2
        String s2 = "bbbbb";
        System.out.println("输入: " + s2 + "，输出: " + solution.lengthOfLongestSubstring(s2)); // 1

        // 测试用例 3
        String s3 = "pwwkew";
        System.out.println("输入: " + s3 + "，输出: " + solution.lengthOfLongestSubstring(s3)); // 3

        // 测试用例 4（空串）
        String s4 = "";
        System.out.println("输入: " + s4 + "，输出: " + solution.lengthOfLongestSubstring(s4)); // 0

        // 测试用例 5（无重复字符）
        String s5 = "abcdefg";
        System.out.println("输入: " + s5 + "，输出: " + solution.lengthOfLongestSubstring(s5)); // 7
    }
}
