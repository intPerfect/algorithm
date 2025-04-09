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
            int[] cntP = new int[26]; // 统计 p 的字母频率
            int[] cntS = new int[26]; // 统计 s 的字母频率
            // 记录 p 中每个字母出现的次数
            for (char c : p.toCharArray()) {
                cntP[c - 'a']++;
            }
            // 使用滑动窗口遍历 s
            for (int right = 0; right < s.length(); right++) {
                // 右指针进入窗口，更新 s 中当前字母频率
                cntS[s.charAt(right) - 'a']++;
                // 当窗口大小达到 p 的长度时，开始比较窗口内字母频率
                int left = right - p.length() + 1;
                if (left < 0) { // 窗口长度不足 p.length()
                    continue;
                }
                // 如果 s 窗口内的字母频率与 p 相等，则记录此起始索引
                if (Arrays.equals(cntS, cntP)) {
                    ans.add(left);
                }
                // 左指针离开窗口，更新窗口内字母频率
                cntS[s.charAt(left) - 'a']--;
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
