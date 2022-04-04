package com.kkzhang.medium;

import org.junit.Test;

public class InterleavingStringTest {
    private InterleavingString solution = new InterleavingString();
    @Test
    public void testInterleavingString() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.print(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void testInterleavingString_1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.print(solution.isInterleave(s1, s2, s3));
    }
}
