package com.kkzhang.medium;

import org.junit.Test;

public class SumOfSquareNumbersTest {
    private SumOfSquareNumbers solution = new SumOfSquareNumbers();

    @Test
    public void testSumOfSquareNumbers() {
        int n = 2147483600;
        boolean res = solution.judgeSquareSum(n);
        System.out.print(res);
    }
}
