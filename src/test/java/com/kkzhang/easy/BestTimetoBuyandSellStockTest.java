package com.kkzhang.easy;

import org.junit.Test;

public class BestTimetoBuyandSellStockTest {
    private BestTimetoBuyandSellStock solution = new BestTimetoBuyandSellStock();

    @Test
    public void testBestTimetoBuyandSellStock() {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(solution.maxProfit(prices));
    }
}
