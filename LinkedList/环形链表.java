package LinkedList;

import java.util.*;

/**
 * @LeetCodeId 141
 * @LeetCodeLink <a href="https://leetcode.cn/problems/linked-list-cycle/">环形链表</a>
 * @Date 2025/05/06
 */
public class 环形链表 {
    // 单链表节点定义
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
         * 方法一：使用 HashSet 记录访问过的节点
         */
        public boolean hasCycleUsingSet(ListNode head) {
            Set<ListNode> seen = new HashSet<>();
            while (head != null) {
                if (!seen.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }

        /**
         * 方法二：使用 Floyd 判圈算法（快慢指针）
         * 快指针每次移动两步，慢指针每次移动一步
         * 若有环，则快慢指针最终会相遇
         */
        public boolean hasCycleUsingFloyd(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast) {
                // 快指针遇到 null，说明无环
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            return true; // 快慢指针相遇，说明存在环
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: 链表为 [3,2,0,-4], pos = 1，环连接到节点值为2的位置
        ListNode head1 = new ListNode(3);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(0);
        ListNode node1_4 = new ListNode(-4);
        head1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_2; // 创建环
        System.out.println("测试用例 1: " + solution.hasCycleUsingSet(head1));    // 输出: true
        System.out.println("测试用例 1: " + solution.hasCycleUsingFloyd(head1));  // 输出: true

        // 测试用例 2: 链表为 [1,2], pos = 0，环连接到节点值为1的位置
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        node2_2.next = head2; // 创建环
        System.out.println("测试用例 2: " + solution.hasCycleUsingSet(head2));    // 输出: true
        System.out.println("测试用例 2: " + solution.hasCycleUsingFloyd(head2));  // 输出: true

        // 测试用例 3: 链表为 [1], pos = -1，无环
        ListNode head3 = new ListNode(1);
        System.out.println("测试用例 3: " + solution.hasCycleUsingSet(head3));    // 输出: false
        System.out.println("测试用例 3: " + solution.hasCycleUsingFloyd(head3));  // 输出: false
    }
}
