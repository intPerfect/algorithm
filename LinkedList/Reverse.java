package LinkedList;

import java.util.*;

/**
 * @LeetCodeId 206
 * @LeetCodeLink <a href="https://leetcode.cn/problems/reverse-linked-list/">反转链表</a>
 * @Frequency 🔥🔥🔥
 * @Date 2025/05/06
 */
public class Reverse {
    // 链表节点定义
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        /**
         * 反转单链表
         *
         * @param head 链表头节点
         * @return 反转后的链表头节点
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;      // 前一个节点初始为 null
            ListNode curr = head;      // 当前节点从头节点开始遍历

            while (curr != null) {
                ListNode nextTemp = curr.next; // 暂存下一个节点
                curr.next = prev;              // 当前节点指向前一个节点，实现反转
                prev = curr;                   // 移动前驱节点指针
                curr = nextTemp;               // 移动当前节点指针
            }

            // 循环结束后，prev 指向新链表的头节点
            return prev;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1：head = [1, 2, 3, 4, 5]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        printList(solution.reverseList(head1));  // 输出：[5, 4, 3, 2, 1]

        // 测试用例 2：head = [1, 2]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        printList(solution.reverseList(head2));  // 输出：[2, 1]

        // 测试用例 3：head = []
        ListNode head3 = null;
        printList(solution.reverseList(head3));  // 输出：[]
    }

    /**
     * 打印链表
     */
    private static void printList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        System.out.println(result);
    }
}
