package com.kkzhang.medium;

import org.junit.Test;

public class MinimumPathSumTest {
    @Test
    public void testMinPathSum() {
        int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(MinimumPathSum.minPathSum(grid));
    }
}
