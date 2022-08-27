package com.kkzhang.easy;

import org.junit.Test;

public class ValidPalindromeIITest {
    private ValidPalindromeII solution = new ValidPalindromeII();

    @Test
    public void testValidPalindromeII() {
        String s = "abca";
        boolean res = solution.validPalindrome2(s);
        System.out.print(res);
    }
}
