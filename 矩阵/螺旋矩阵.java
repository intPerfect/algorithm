package 矩阵;

import java.util.*;

/**
 * @LeetCodeId 54
 * @LeetCodeLink <a href="https://leetcode.cn/problems/spiral-matrix">螺旋矩阵</a>
 * @Date 2025-07-26
 */
public class 螺旋矩阵 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length;
            if (n == 0) {
                return new ArrayList<>();
            }

            int l = 0, r = matrix[0].length - 1, t = 0, b = n - 1, x = 0;
            Integer[] res = new Integer[(r + 1) * (b + 1)];
            while (true) {
                // 从左到右
                for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
                if (++t > b) break; // 上边界收缩
                // 从上到下
                for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
                if (--r < l) break; // 右边界收缩
                // 从右到左
                for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
                if (--b < t) break; // 下边界收缩
                // 从下到上
                for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
                if (++l > r) break; // 左边界收缩
            }
            return Arrays.asList(res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix1)); // 输出: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // 测试用例 2
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix2)); // 输出: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
