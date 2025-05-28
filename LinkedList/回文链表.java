package LinkedList;

import java.util.*;

/**
 * @LeetCodeId 234
 * @LeetCodeLink <a href="https://leetcode.cn/problems/palindrome-linked-list/">回文链表</a>
 * @Frequency 🔥
 * @Date 2025-05-06
 */
public class 回文链表 {
    // 单链表节点定义
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        /**
         * 判断链表是否为回文链表
         *
         * @param head 链表头节点
         * @return 是否为回文
         */
        public boolean isPalindrome(ListNode head) {
            // 将链表的值依次存入列表中
            List<Integer> vals = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                vals.add(curr.val);
                curr = curr.next;
            }

            // 使用双指针从两端向中间比较
            for (int front = 0, back = vals.size() - 1; front < back; front++, back--) {
                if (!vals.get(front).equals(vals.get(back))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: 回文链表 [1,2,2,1]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(solution.isPalindrome(head1)); // 输出 true

        // 测试用例 2: 非回文链表 [1,2]
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println(solution.isPalindrome(head2)); // 输出 false

        // 测试用例 3: 单个节点 [1]
        ListNode head3 = new ListNode(1);
        System.out.println(solution.isPalindrome(head3)); // 输出 true
    }
}
