package com.kkzhang.medium;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

    @Test
    public void testLengthOfLCS() {
        int[] nums = new int[] {3,6,2,7};
        int max = solution.lengthOfLIS(nums);
        System.out.println(max);
    }
}
