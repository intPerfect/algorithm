package Math;

/**
 * @LeetCodeId 136
 * @LeetCodeLink <a href="https://leetcode.cn/problems/single-number">只出现一次的数字</a>
 * @Date 2025/04/18
 */
public class 只出现一次的数字 {
    static class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                // 出现两次的数字，异或后为 0
                single ^= num;
            }
            return single;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {2, 2, 1};
        System.out.println("测试用例 1 输出：" + solution.singleNumber(nums1)); // 1

        // 测试用例 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("测试用例 2 输出：" + solution.singleNumber(nums2)); // 4

        // 测试用例 3
        int[] nums3 = {1};
        System.out.println("测试用例 3 输出：" + solution.singleNumber(nums3)); // 1
    }
}
