package com.kkzhang.easy;

import org.junit.Test;

public class Numberof1BitsTest {

    private Numberof1Bits solution = new Numberof1Bits();

    @Test
    public void testNumberof1Bits() {
        int n = 5;
        int res = solution.hammingWeight(n);
        System.out.print(res);
    }
}
