package com.kkzhang.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonoverlappingIntervals {

    // 贪心策略：优先保留结尾小且不相交的区间
    // 每次选择结束时间最小且不冲突的元素
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照结束时间进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int i = 0;
        int j = i + 1;
        int n = intervals.length;
        int nonOverlappingCount = 1;
        while (i < n && j < n) {
            // 如果当前结束时间小于下一个元素的开始时间，那么不会被覆盖
            if (intervals[i][1] <= intervals[j][0]) {
                nonOverlappingCount++;
                i = j;
            }
            j++;
        }
        return n - nonOverlappingCount;
    }

}
