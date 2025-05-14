package Stack;

import java.util.*;

/**
 * @LeetCodeId 20
 * @LeetCodeLink <a href="https://leetcode.cn/problems/valid-parentheses/">有效的括号</a>
 * @Frequency 🔥🔥🔥
 * @Date 2025-04-18
 */
public class 有效的括号 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                // 遇到左括号，右括号入栈
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else {
                    // 遇到右括号，栈顶元素出栈，与当前右括号匹配
                    if (stack.isEmpty() || stack.pop() != c) {
                        // 不匹配，返回 false
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String test1 = "()";
        System.out.println("输入: \"" + test1 + "\", 输出: " + solution.isValid(test1));

        // 测试用例 2
        String test2 = "()[]{}";
        System.out.println("输入: \"" + test2 + "\", 输出: " + solution.isValid(test2));

        // 测试用例 3
        String test3 = "(]";
        System.out.println("输入: \"" + test3 + "\", 输出: " + solution.isValid(test3));

        // 测试用例 4
        String test4 = "([])";
        System.out.println("输入: \"" + test4 + "\", 输出: " + solution.isValid(test4));
    }
}

