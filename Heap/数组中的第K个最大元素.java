package Heap;

import java.util.*;

/**
 * @LeetCodeId 215
 * @LeetCodeLink <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array">数组中的第K个最大元素</a>
 * @Date 2025-05-06
 */
public class 数组中的第K个最大元素 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 创建一个小顶堆，用于维护当前最大的k个元素
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            // 不断换出堆顶元素，使得堆中保存的元素始终是当前最大的k个元素
            for (int num : nums) {
                if (heap.size() < k) {
                    // 堆中元素少于k个，直接加入
                    heap.add(num);
                } else if (num > heap.peek()) {
                    // 当前元素 > 堆顶元素（堆中最小的元素），换出堆顶元素
                    heap.poll();
                    heap.add(num);
                }
            }

            // 小顶堆的堆顶元素即为数组中的第k大元素
            return heap.poll();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("输出: " + solution.findKthLargest(nums1, k1)); // 输出: 5

        // 测试用例 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("输出: " + solution.findKthLargest(nums2, k2)); // 输出: 4
    }
}
