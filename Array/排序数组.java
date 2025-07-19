package Array;

import java.util.*;

/**
 * @LeetCodeId 912
 * @LeetCodeLink <a href="https://leetcode.cn/problems/sort-an-array/">排序数组</a>
 * @Date 2025/07/19
 */
public class 排序数组 {
    static class Solution {
        private Random random = new Random();

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int index = random.nextInt(right - left + 1) + left;  // 随机索引
                swap(nums, index, right);  // 将随机元素放到最右边，作为 pivot
                int pivot = nums[right];
                int i = left, j = right - 1;

                while (true) {
                    while (i <= j && nums[i] < pivot) i++;
                    while (i <= j && nums[j] > pivot) j--;
                    if (i > j) break;
                    swap(nums, i++, j--);
                }

                swap(nums, i, right);  // 把 pivot 放回正确位置
                quickSort(nums, left, i - 1);
                quickSort(nums, i + 1, right);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(solution.sortArray(nums1)));  // 输出：[1, 2, 3, 5]

        // 测试用例 2
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(solution.sortArray(nums2)));  // 输出：[0, 0, 1, 1, 2, 5]

        // 测试用例 3
        int[] nums3 = {1};
        System.out.println(Arrays.toString(solution.sortArray(nums3)));  // 输出：[1]
    }
}
