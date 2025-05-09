package Array;

import java.util.*;

/**
 * @LeetCodeId 73
 * @LeetCodeLink <a href="https://leetcode.cn/problems/set-matrix-zeroes">矩阵置零</a>
 * @Date 2025-05-09
 */
public class 矩阵置零 {
    static class Solution {
        /**
         * 原地将矩阵中所有包含 0 的行和列置为 0。
         *
         * @param matrix 输入的二维矩阵
         */
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            // 标记第一行和第一列是否原本含有0
            boolean row0_flag = false;
            boolean col0_flag = false;

            // 检查第一行是否有0
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    row0_flag = true;
                    break;
                }
            }

            // 检查第一列是否有0
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    col0_flag = true;
                    break;
                }
            }

            // 使用第一行和第一列作为标志位，标记其他需要置零的行和列
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0; // 标记当前行
                        matrix[0][j] = 0; // 标记当前列
                    }
                }
            }

            // 根据标志位将对应的元素置零
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // 处理第一行
            if (row0_flag) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }

            // 处理第一列
            if (col0_flag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        System.out.println("测试用例 1:");
        printMatrix(matrix1); // 应输出 [[1,0,1],[0,0,0],[1,0,1]]

        // 测试用例 2
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        System.out.println("测试用例 2:");
        printMatrix(matrix2); // 应输出 [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

