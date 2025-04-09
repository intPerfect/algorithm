import java.util.*;

/**
 * @LeetCodeId 1
 * @LeetCodeLink <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 * @Date 2025-04-09
 */
public class 两数之和 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 将 x + y = target 转化为 x = target - y
                int key = target - nums[i];
                // 查表得到 x 的索引
                if (hash.containsKey(key)) {
                    return new int[]{hash.get(key), i};
                } else {
                    // 添加当前元素和索引到哈希表中
                    hash.put(nums[i], i);
                }
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("测试用例 1: " + Arrays.toString(solution.twoSum(nums1, target1))); // 输出: [0, 1]

        // 测试用例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("测试用例 2: " + Arrays.toString(solution.twoSum(nums2, target2))); // 输出: [1, 2]

        // 测试用例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("测试用例 3: " + Arrays.toString(solution.twoSum(nums3, target3))); // 输出: [0, 1]
    }
}
