package 哈希;

import java.util.*;

/**
 * @LeetCodeId 49
 * @LeetCodeLink <a href="https://leetcode-cn.com/problems/group-anagrams/">字母异位词分组</a>
 * @Date 2025.4.4
 */
public class 字母异位词分组 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 将排序后的字符串作为聚合键，对应字母异位词列表
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                // 转为字符数组 charArray 并排序，得到聚合键 key
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                // 将当前字符串 str 加入到对应聚合键 key 的列表 words 中
                List<String> words = map.getOrDefault(key, new ArrayList<>());
                words.add(str);
                map.put(key, words);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(test1));

        // 测试用例 2
        String[] test2 = {""};
        System.out.println(solution.groupAnagrams(test2));

        // 测试用例 3
        String[] test3 = {"a"};
        System.out.println(solution.groupAnagrams(test3));

        // 额外测试用例：包含相同字母的单词
        String[] test4 = {"abc", "bca", "cab", "xyz", "yxz", "zxy"};
        System.out.println(solution.groupAnagrams(test4));

        // 额外测试用例：包含不同长度的单词
        String[] test5 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(solution.groupAnagrams(test5));
    }
}
