package com.kkzhang.medium;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    private SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

    @Test
    public void testSearchInRotatedSortedArray() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int index = solution.search(nums, target);
        System.out.print(index);
    }
}
