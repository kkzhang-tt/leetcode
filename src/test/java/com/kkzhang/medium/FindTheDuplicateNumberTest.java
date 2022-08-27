package com.kkzhang.medium;

import org.junit.Test;

public class FindTheDuplicateNumberTest {
    private FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

    @Test
    public void testFindTheDuplicateNumber() {
        int[] array = new int[]{3, 1, 3, 4, 2};
        int res = solution.findDuplicate(array);
        System.out.print(res);
    }
}
