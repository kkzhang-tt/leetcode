package com.kkzhang.medium;

import org.junit.Test;

public class CoinChangeTest {

    private CoinChange solution = new CoinChange();

    @Test
    public void testCoinChange() {
        int amount = 3;
        int[] coins = new int[] { 2 };
        int count = solution.coinChange(coins, amount);
        System.out.print(count);
    }
}
