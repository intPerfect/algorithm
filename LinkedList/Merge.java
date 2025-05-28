package LinkedList;

/**
 * @LeetCodeId 21
 * @LeetCodeLink <a href="https://leetcode.cn/problems/merge-two-sorted-lists">merge-two-sorted-lists</a>
 * @Date 2025-05-28
 */
public class Merge {
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

        // 打印链表，辅助测试
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) sb.append(" -> ");
                current = current.next;
            }
            return sb.toString();
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 创建一个虚拟头节点
            ListNode head = new ListNode(-1);
            ListNode prev = head;

            // 逐个比较两个链表的节点，并链接到新链表中
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 剩下没有合并进去的节点，直接链接到新链表中
            prev.next = l1 == null ? l2 : l1;

            return head.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("合并后链表: " + solution.mergeTwoLists(l1, l2));

        // 测试用例 2
        l1 = null;
        l2 = null;
        System.out.println("合并后链表: " + solution.mergeTwoLists(l1, l2));

        // 测试用例 3
        l1 = null;
        l2 = new ListNode(0);
        System.out.println("合并后链表: " + solution.mergeTwoLists(l1, l2));
    }
}
