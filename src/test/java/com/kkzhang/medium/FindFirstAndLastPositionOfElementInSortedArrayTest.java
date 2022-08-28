package com.kkzhang.medium;

import org.junit.Test;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {
    private FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();

    @Test
    public void testFindFirstAndLastPositionOfElementInSortedArray() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] res = solution.searchRange(nums, target);
        System.out.print(Arrays.toString(res));
    }
}
