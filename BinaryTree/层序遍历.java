package BinaryTree;

import java.util.*;

/**
 * @LeetCodeId 102
 * @LeetCodeLink <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal">二叉树的层序遍历</a>
 * @Date 2025-06-06
 */
public class 层序遍历 {

    // 二叉树节点定义
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>(); // 第 i 层的节点队列
            List<List<Integer>> res = new ArrayList<>(); // 总结果集

            // 根节点入队
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> tmp = new ArrayList<>(); // 当前层结果集
                // 遍历当前层的所有节点：
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    // 依次取出队头节点，①将其值添加到结果集，
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    // ②并将其左右子树入队，以便下一层遍历
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(solution.levelOrder(root1)); // 输出：[[3], [9, 20], [15, 7]]

        // 测试用例 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.levelOrder(root2)); // 输出：[[1]]

        // 测试用例 3
        TreeNode root3 = null;
        System.out.println(solution.levelOrder(root3)); // 输出：[]
    }
}
