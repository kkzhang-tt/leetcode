package com.kkzhang.medium;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingTest {
    @Test
    public void testSolution() {
        String s = "abcabcbb";
        int length = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    @Test
    public void testSolution_1() {
        String s = "bbbbb";
        int length = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    @Test
    public void testSolution_2() {
        String s = "abba";
        int length = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
