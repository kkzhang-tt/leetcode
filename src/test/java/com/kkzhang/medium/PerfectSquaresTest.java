package com.kkzhang.medium;

import org.junit.Test;

public class PerfectSquaresTest {

    private PerfectSquares solution = new PerfectSquares();

    @Test
    public void testPerfectSquares() {
        int n = 13;
        int res = solution.numSquares(n);
        System.out.println(res);
    }
}
