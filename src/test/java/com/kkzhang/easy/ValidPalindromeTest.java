package com.kkzhang.easy;

import org.junit.Test;

public class ValidPalindromeTest {

    private ValidPalindrome solution = new ValidPalindrome();

    @Test
    public void testValidPalindrome() {
        String s = " ";
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        boolean res = solution.isPalindrome(s2);
        System.out.print(res);
    }
}
