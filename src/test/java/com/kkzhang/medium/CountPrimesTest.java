package com.kkzhang.medium;

import org.junit.Test;

public class CountPrimesTest {

    private CountPrimes solution = new CountPrimes();

    @Test
    public void testCountPrimes() {
        int n = 499979;
        int res = solution.countPrimes(n);
        System.out.println(res);
    }
}
