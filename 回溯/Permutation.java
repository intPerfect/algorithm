package 回溯;

import java.util.*;

/**
 * @LeetCodeId 46
 * @LeetCodeLink <a href="https://leetcode.cn/problems/permutations">全排列</a>
 * @Frequency 257
 * @Date 2025-06-07
 */
public class Permutation {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();
            dfs(nums, len, 0, path, used, res);
            return res;
        }

        // 使用回溯算法生成全排列
        private void dfs(int[] nums, int len, int depth, List<Integer> path,
                         boolean[] used, List<List<Integer>> res) {
            // 当路径长度等于数组长度时，找到一个完整排列
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);       // 选择当前数字
                    used[i] = true;          // 标记为已使用

                    // 递归搜索下一个数字
                    dfs(nums, len, depth + 1, path, used, res);

                    used[i] = false;         // 回溯，取消选择
                    path.remove(path.size() - 1); // 移除最后一个元素
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println("输入: [1,2,3]");
        System.out.println("输出: " + solution.permute(nums1));

        // 测试用例 2
        int[] nums2 = {0, 1};
        System.out.println("输入: [0,1]");
        System.out.println("输出: " + solution.permute(nums2));

        // 测试用例 3
        int[] nums3 = {1};
        System.out.println("输入: [1]");
        System.out.println("输出: " + solution.permute(nums3));
    }
}

