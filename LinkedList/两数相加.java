package LinkedList;

/**
 * @LeetCodeId 2
 * @LeetCodeLink <a href="https://leetcode.cn/problems/add-two-numbers/">两数相加</a>
 * @Date 2025/05/09
 */
public class 两数相加 {
    // 链表节点定义（LeetCode 默认定义）
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode curr = this;
            while (curr != null) {
                sb.append(curr.val);
                if (curr.next != null) sb.append(" -> ");
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2, 0);
        }

        /**
         * 递归地将两个链表表示的数字相加
         *
         * @param l1    第一个链表节点
         * @param l2    第二个链表节点
         * @param carry 进位值
         * @return 返回相加后的链表节点
         */
        private ListNode add(ListNode l1, ListNode l2, int carry) {
            // 终止条件：两个链表遍历完且无进位
            if (l1 == null && l2 == null && carry == 0) {
                return null;
            }

            int sum = carry;

            // 当前位相加
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 构造当前节点（保留个位）
            // 例如 7 + 8 = 15，则当前节点值为 15 % 10 = 5，进位值为 15 / 10 = 1
            ListNode node = new ListNode(sum % 10);

            // 继续处理下一位（传递进位）
            node.next = add(l1, l2, sum / 10);

            return node;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: [2,4,3] + [5,6,4] => [7,0,8]
        // 342 + 465 = 807 (7 -> 0 -> 8)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println("输入: [2,4,3] + [5,6,4]");
        System.out.println("输出: " + solution.addTwoNumbers(l1, l2));  // 7 -> 0 -> 8

        // 测试用例 2: [0] + [0] => [0]
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        System.out.println("\n输入: [0] + [0]");
        System.out.println("输出: " + solution.addTwoNumbers(l1, l2));  // 0

        // 测试用例 3: [9,9,9,9,9,9,9] + [9,9,9,9] => [8,9,9,9,0,0,0,1]
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println("\n输入: [9,9,9,9,9,9,9] + [9,9,9,9]");
        System.out.println("输出: " + solution.addTwoNumbers(l1, l2));  // 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }
}
