package 滑动窗口;

import java.util.*;

/**
 * @LeetCodeId 239
 * @LeetCodeLink <a href="https://leetcode.cn/problems/sliding-window-maximum">滑动窗口最大值</a>
 * @Frequency 🔥🔥
 * @Date 2025-06-10
 */
public class 滑动窗口最大值 {
    static class Solution {
        /**
         * 计算滑动窗口中的最大值
         *
         * @param nums 输入数组
         * @param k    窗口大小
         * @return 每个窗口的最大值组成的数组
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if (len == 0 || k == 0) return new int[0];

            // 单调队列，保证队列递减
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[len - k + 1];

            for (int j = 0, i = 1 - k; j < len; i++, j++) {
                // 如果滑出窗口的元素 (nums[i-1]) 是当前最大值，则从队列头部移除
                if (i >= 1 && deque.peekFirst() == nums[i - 1]) {
                    deque.removeFirst();
                }
                // 保持队列递减，移除所有比当前元素小的尾部元素
                while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                    deque.removeLast();
                }
                // 将当前元素加入队列尾部
                deque.addLast(nums[j]);
                // 记录当前窗口的最大值
                if (i >= 0) {
                    res[i] = deque.peekFirst();
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums1, k1))); // 输出：[3, 3, 5, 5, 6, 7]

        // 测试用例 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums2, k2))); // 输出：[1]

        // 测试用例 3
        int[] nums3 = {9, 11};
        int k3 = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums3, k3))); // 输出：[11]

        // 测试用例 4
        int[] nums4 = {4, -2};
        int k4 = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums4, k4))); // 输出：[4]
    }
}
