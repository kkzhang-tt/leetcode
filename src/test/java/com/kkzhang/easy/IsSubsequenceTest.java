package com.kkzhang.easy;

import org.junit.Test;

public class IsSubsequenceTest {

    private IsSubsequence solution = new IsSubsequence();

    @Test
    public void testIsSubsequence() {
        String s = "axc";
        String t = "ahbgdc";
        boolean res = solution.isSubsequence(s, t);
        System.out.println(res);
    }
}
