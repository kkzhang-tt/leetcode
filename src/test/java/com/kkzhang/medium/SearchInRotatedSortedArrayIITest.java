package com.kkzhang.medium;

import org.junit.Test;

public class SearchInRotatedSortedArrayIITest {
    private SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();

    @Test
    public void testSearchInRotatedSortedArrayII() {
        int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int target = 2;
        boolean res = solution.search(array, target);
        System.out.print(res);
    }
}
