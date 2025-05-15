package 滑动窗口;

import java.util.*;

/**
 * @LeetCodeId 438
 * @LeetCodeLink <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">找到字符串中所有字母异位词</a>
 * @Date 2025-04-09
 */
public class 找到字符串中所有字母异位词 {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) return ans;

            int[] pCount = new int[26];
            int[] sCount = new int[26];

            // 先统计模式串 p 的字符频率
            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            int left = 0, right = 0;
            while (right < s.length()) {
                // 右指针字符进入窗口
                sCount[s.charAt(right) - 'a']++;

                // 如果窗口大小等于 p.length()，就可以检查是否是异位词
                if (right - left + 1 == p.length()) {
                    // 窗口串 s 的字符频率和模式串 p 相同
                    if (Arrays.equals(sCount, pCount)) {
                        // 将左指针加入结果集
                        ans.add(left);
                    }
                    // 左指针字符移出窗口
                    sCount[s.charAt(left) - 'a']--;
                    left++;
                }

                // 右指针继续扩张窗口
                right++;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("测试用例 1: " + solution.findAnagrams(s1, p1)); // 输出应为 [0,6]

        // 测试用例 2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println("测试用例 2: " + solution.findAnagrams(s2, p2)); // 输出应为 [0,1,2]
    }
}
