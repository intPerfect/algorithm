package BinaryTree;

import java.util.*;

/**
 * @LeetCodeId 94
 * @LeetCodeLink <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal">二叉树的中序遍历</a>
 * @Date 2025-05-06
 */
public class 中序遍历 {
    // 定义二叉树节点结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        // 二叉树中序遍历：L -> V -> R
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        // 辅助递归方法
        private void inorder(TreeNode node, List<Integer> res) {
            if (node == null) return;
            inorder(node.left, res);      // 递归访问左子树
            res.add(node.val);            // 访问当前节点
            inorder(node.right, res);     // 递归访问右子树
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: [1,null,2,3]
        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);
        System.out.println("测试用例1输出: " + solution.inorderTraversal(test1)); // [1,3,2]

        // 测试用例 2: []
        TreeNode test2 = null;
        System.out.println("测试用例2输出: " + solution.inorderTraversal(test2)); // []

        // 测试用例 3: [1]
        TreeNode test3 = new TreeNode(1);
        System.out.println("测试用例3输出: " + solution.inorderTraversal(test3)); // [1]
    }
}
