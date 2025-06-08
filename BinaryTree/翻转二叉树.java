package BinaryTree;

import java.util.*;

/**
 * @LeetCodeId 226
 * @LeetCodeLink <a href="https://leetcode.cn/problems/invert-binary-tree/">翻转二叉树</a>
 * @Date 2025-05-13
 */
public class 翻转二叉树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 反转根节点的左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // 递归反转左右子树
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }

    // 辅助方法：构造二叉树
    private static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // 辅助方法：层序遍历输出二叉树
    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        TreeNode root1 = buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode inverted1 = solution.invertTree(root1);
        System.out.println("输出：" + levelOrder(inverted1)); // 应输出：[4, 7, 2, 9, 6, 3, 1]

        // 测试用例 2
        TreeNode root2 = buildTree(new Integer[]{2, 1, 3});
        TreeNode inverted2 = solution.invertTree(root2);
        System.out.println("输出：" + levelOrder(inverted2)); // 应输出：[2, 3, 1]

        // 测试用例 3
        TreeNode root3 = buildTree(new Integer[]{});
        TreeNode inverted3 = solution.invertTree(root3);
        System.out.println("输出：" + levelOrder(inverted3)); // 应输出：[]
    }
}
