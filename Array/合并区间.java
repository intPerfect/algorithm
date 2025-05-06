package Array;

import java.util.*;

/**
 * @LeetCodeId 56
 * @LeetCodeLink <a href="https://leetcode.cn/problems/merge-intervals">合并区间</a>
 * @Date 2025-04-18
 */
public class 合并区间 {
    static class Solution {
        public List<List<String>> mergeList(List<List<String>> intervalsStr) {
            int[][] intervals = new int[intervalsStr.size()][2];
            for (int i = 0; i < intervalsStr.size(); i++) {
                intervals[i][0] = Integer.parseInt(intervalsStr.get(i).get(0));
                intervals[i][1] = Integer.parseInt(intervalsStr.get(i).get(1));
            }

            int[][] merged = merge(intervals);

            List<List<String>> result = new ArrayList<>();
            for (int[] interval : merged) {
                result.add(Arrays.asList(String.valueOf(interval[0]), String.valueOf(interval[1])));
            }
            return result;
        }

        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            if (n == 0) {
                return new int[0][2];
            }

            // 以左端点排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            // 合并结果
            List<int[]> merged = new ArrayList<>();

            // 遍历区间
            for (int[] interval : intervals) {
                // 当前区间 [L, R]
                int L = interval[0], R = interval[1];
                // 合并区间 [l, r]
                int topR = merged.size() - 1;
                // L > r，增加新合并区间
                if (merged.isEmpty() || L > merged.get(topR)[1]) {
                    merged.add(new int[]{L, R});
                } else {
                    // L <= r，进行区间合并，更新 r = max(r, R)
                    merged.get(topR)[1] = Math.max(merged.get(topR)[1], R);
                }
            }

            // 转换为数组并返回
            return merged.toArray(new int[merged.size()][]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        List<List<String>> test1 = Arrays.asList(
                Arrays.asList("1", "3"),
                Arrays.asList("2", "6"),
                Arrays.asList("8", "10"),
                Arrays.asList("15", "18")
        );
        // 合并结果：[[1,6], [8,10], [15,18]]
        System.out.println("测试用例1结果：" + solution.mergeList(test1));

        // 测试用例 2
        List<List<String>> test2 = Arrays.asList(
                Arrays.asList("1", "4"),
                Arrays.asList("4", "5")
        );
        // 合并结果：[[1,4], [5,6]]
        System.out.println("测试用例2结果：" + solution.mergeList(test2));

        // 测试用例 3（无重叠）
        List<List<String>> test3 = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("3", "4"),
                Arrays.asList("5", "6")
        );
        // 合并结果：[[1,2], [3,4], [5,6]]
        System.out.println("测试用例3结果：" + solution.mergeList(test3));
    }
}
