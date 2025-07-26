package Heap;

import java.util.*;

/**
 * @LeetCodeId 347
 * @LeetCodeLink <a href="https://leetcode.cn/problems/top-k-frequent-elements">前 K 个高频元素</a>
 * @Date 2025-05-13
 * @Frequency 33
 */
public class 前K个高频元素 {
    static class Solution {

        // 解法一：使用排序
        public int[] topKFrequentSort(int[] nums, int k) {
            // 1. 统计每个元素出现的频率
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // 2. 按照频率排序（value）
            var entryList = new ArrayList<>(freqMap.entrySet());
            entryList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 按 value 降序排列

            // 3. 取前 k 个元素
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = entryList.get(i).getKey();
            }

            return result;
        }

        // 解法二：使用堆
        public int[] topKFrequentHeap(int[] nums, int k) {
            // 1. 统计每个元素出现的频率
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // 2. 使用小根堆保存频率最高的 k 个元素
            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                    (a, b) -> a.getValue() - b.getValue() // 按频率升序排列
            );

            // 3. 维护堆的大小为 k，堆顶是频率最小的元素
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                minHeap.offer(entry);
                if (minHeap.size() > k) {
                    minHeap.poll(); // 移除堆顶元素
                }
            }

            // 4. 从堆中提取元素并返回结果
            int[] result = new int[k];
            int i = 0;
            while (!minHeap.isEmpty()) {
                result[i++] = minHeap.poll().getKey();
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(solution.topKFrequentSort(nums1, k1))); // 输出: [1, 2]
        System.out.println(Arrays.toString(solution.topKFrequentHeap(nums1, k1)));  // 输出: [1, 2]

        // 测试用例 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.topKFrequentSort(nums2, k2))); // 输出: [1]
        System.out.println(Arrays.toString(solution.topKFrequentHeap(nums2, k2)));  // 输出: [1]
    }
}
