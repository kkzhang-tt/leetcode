package com.kkzhang.easy;

import org.junit.Test;

public class CountingBitsTest {

    private CountingBits solution = new CountingBits();

    @Test
    public void testCountingBits() {
        int n = 5;
        int[] res = solution.countBits(n);
        printArr(res);
    }

    private void printArr(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
