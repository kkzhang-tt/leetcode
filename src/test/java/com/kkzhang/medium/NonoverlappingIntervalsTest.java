package com.kkzhang.medium;

import org.junit.Test;

public class NonoverlappingIntervalsTest {
    private NonoverlappingIntervals solution = new NonoverlappingIntervals();

    @Test
    public void testNonoverlappingIntervals() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int count = solution.eraseOverlapIntervals(intervals);
        System.out.print(count);
    }
}
