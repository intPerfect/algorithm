package 递归;

import java.util.*;

/**
 * @LeetCodeId 17
 * @LeetCodeLink <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number">电话号码的字母组合</a>
 * @Date 2025/05/06
 */
public class 电话号码的字母组合 {
    static class Solution {
        // 定义每个数字对应的字母映射
        private static final String[] MAPPING = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        /**
         * 主方法：返回所有可能的字母组合
         */
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            // 边界条件：如果输入为空，直接返回空结果
            if (digits == null || digits.isEmpty()) return result;

            // 递归回溯生成所有组合
            backtrack(result, digits, 0, new StringBuilder());
            return result;
        }

        /**
         * 回溯函数
         *
         * @param result 保存所有可能组合的结果集
         * @param digits 原始输入数字字符串 ("256")
         * @param index  当前处理到的字符位置
         * @param path   当前已构建的组合路径
         */
        private void backtrack(List<String> result, String digits,
                               int index, StringBuilder path) {
            // 如果路径长度等于输入长度，说明构建完成一个组合
            if (index == digits.length()) {
                result.add(path.toString());
                return;
            }

            // 获取当前数字对应的所有字母
            String letters = MAPPING[digits.charAt(index) - '0'];
            for (char c : letters.toCharArray()) {
                // 添加当前字母到路径
                path.append(c);
                // 递归处理下一个数字
                backtrack(result, digits, index + 1, path);
                // 回溯，移除当前添加的字母
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        System.out.println(solution.letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        // 测试用例 2
        System.out.println(solution.letterCombinations("")); // []

        // 测试用例 3
        System.out.println(solution.letterCombinations("2")); // ["a","b","c"]
    }
}
