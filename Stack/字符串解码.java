package Stack;

import java.util.*;

/**
 * @LeetCodeId 394
 * @LeetCodeLink <a href="https://leetcode.cn/problems/decode-string">字符串解码</a>
 * @Date 2025-05-13
 */
public class 字符串解码 {
    static class Solution {
        public String decodeString(String s) {
            Deque<Integer> countStack = new LinkedList<>(); // 数字栈，用于存储每层的重复次数
            Deque<String> strStack = new LinkedList<>(); // 字符串栈，用于存储每层的中间字符串
            String currentStr = ""; // 当前处理的字符串
            int currentCount = 0; // 当前的重复次数

            for (char ch : s.toCharArray()) {
                // 如果是数字，构造完整的重复次数（考虑多位数）
                if (Character.isDigit(ch)) {
                    currentCount = currentCount * 10 + (ch - '0');
                // 遇到左括号，将当前字符串和计数压栈，开始新的层级
                } else if (ch == '[') {
                    countStack.push(currentCount);
                    strStack.push(currentStr);
                    currentStr = "";
                    currentCount = 0;
                // 遇到右括号，出栈重复字符串并拼接
                } else if (ch == ']') {
                    StringBuilder tmp = new StringBuilder(strStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        tmp.append(currentStr);
                    }
                    currentStr = tmp.toString();
                // 普通字母直接拼接到当前字符串
                } else {
                    currentStr += ch;
                }
            }

            return currentStr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String s1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(s1)); // 输出: aaabcbc

        // 测试用例 2
        String s2 = "3[a2[c]]";
        System.out.println(solution.decodeString(s2)); // 输出: accaccacc

        // 测试用例 3
        String s3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s3)); // 输出: abcabccdcdcdef

        // 测试用例 4
        String s4 = "abc3[cd]xyz";
        System.out.println(solution.decodeString(s4)); // 输出: abccdcdcdxyz
    }
}
