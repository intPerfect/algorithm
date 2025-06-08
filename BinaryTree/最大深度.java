package BinaryTree;

/**
 * @LeetCodeId 104
 * @LeetCodeLink <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">二叉树的最大深度</a>
 * @Date 2025-05-13
 */
public class 最大深度 {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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
        public int maxDepth(TreeNode root) {
            // 如果根节点为空，深度为0
            if (root == null) {
                return 0;
            } else {
                // 递归计算左右子树的最大深度
                int left = maxDepth(root.left);
                int right = maxDepth(root.right);
                // 树高 = 根节点深度 = 左右子树最大深度 + 1
                return Math.max(left, right) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: 输入 [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("测试用例 1 输出: " + solution.maxDepth(root1)); // 预期输出：3

        // 测试用例 2: 输入 [1,null,2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println("测试用例 2 输出: " + solution.maxDepth(root2)); // 预期输出：2

        // 测试用例 3: 空树 []
        TreeNode root3 = null;
        System.out.println("测试用例 3 输出: " + solution.maxDepth(root3)); // 预期输出：0
    }
}

