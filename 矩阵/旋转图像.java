package 矩阵;

import java.util.*;

/**
 * @LeetCodeId 48
 * @LeetCodeLink <a href="https://leetcode.cn/problems/rotate-image">旋转图像</a>
 * @Date 2025-07-26
 * @Frequency 80
 */
public class 旋转图像 {
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    // 暂存 1
                    int temp = matrix[i][j];
                    // 4 --> 1
                    matrix[i][j] = matrix[n - 1 - j][i];
                    // 3 --> 4
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    // 2 --> 3
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    // 1 --> 2
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1)); // [[7,4,1],[8,5,2],[9,6,3]]

        // 测试用例 2
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2)); // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}

