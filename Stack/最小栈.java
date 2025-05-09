package Stack;

import java.util.*;

/**
 * @LeetCodeId 155
 * @LeetCodeLink <a href="https://leetcode.cn/problems/min-stack/">最小栈</a>
 * @Date 2025/05/09
 */
public class 最小栈 {
    static class MinStack {
        // 正常栈，用于存储所有元素
        Deque<Integer> numStack;
        // 辅助栈，用于记录每一步的最小值
        Deque<Integer> minStack;

        public MinStack() {
            numStack = new LinkedList<>();
            minStack = new LinkedList<>();
            // 初始化辅助栈，保证第一次比较时有参考值
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            numStack.push(val);
            // 每次 push 都更新当前最小值，压入辅助栈
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            // 同时弹出主栈和辅助栈的栈顶元素，保持同步
            numStack.pop();
            minStack.pop();
        }

        public int top() {
            return numStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // 测试用例 1
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // 输出: -3
        minStack.pop();
        System.out.println(minStack.top());    // 输出: 0
        System.out.println(minStack.getMin()); // 输出: -2
    }
}

