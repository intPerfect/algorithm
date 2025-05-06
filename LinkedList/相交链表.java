package LinkedList;

import java.util.*;

/**
 * @LeetCodeId 160
 * @LeetCodeLink <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">相交链表</a>
 * @Date 2025/05/06
 */
public class 相交链表 {
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
         * 查找两个链表的第一个相交节点
         *
         * @param headA 第一个链表的头节点
         * @param headB 第二个链表的头节点
         * @return 相交的起始节点，若不相交则返回 null
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 使用哈希集合记录链表A的所有节点
            Set<ListNode> visited = new HashSet<>();
            ListNode temp = headA;
            while (temp != null) {
                visited.add(temp);
                temp = temp.next;
            }

            // 遍历链表B，查找是否存在于集合中的节点（即为相交节点）
            temp = headB;
            while (temp != null) {
                if (visited.contains(temp)) {
                    return temp; // 找到相交节点
                }
                temp = temp.next;
            }

            // 没有找到相交节点
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 构建测试用例 1
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println(result != null ? "Intersected at '" + result.val + "'" : "No intersection");

        // 构建测试用例 2
        common = new ListNode(2);
        common.next = new ListNode(4);

        headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = common;

        headB = new ListNode(3);
        headB.next = common;

        result = solution.getIntersectionNode(headA, headB);
        System.out.println(result != null ? "Intersected at '" + result.val + "'" : "No intersection");

        // 构建测试用例 3（无交点）
        headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);

        headB = new ListNode(1);
        headB.next = new ListNode(5);

        result = solution.getIntersectionNode(headA, headB);
        System.out.println(result != null ? "Intersected at '" + result.val + "'" : "No intersection");
    }
}
