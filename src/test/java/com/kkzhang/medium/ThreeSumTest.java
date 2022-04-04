package com.kkzhang.medium;

import java.util.List;

import org.junit.Test;

public class ThreeSumTest {

    ThreeSum tSum = new ThreeSum();

    @Test
    public void testThreeSum() {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = tSum.threeSum_1(nums);
        output(res);
    }

    @Test
    public void testThreeSum_1() {
        int[] nums = new int[] { 13, -11, -14, 4, -9, -10, -11, 7, -14, -9, 14, 0, -5, -7, 6, -9, 11, 6, -14, -12, -10,
                9, -8, -7, 5, 6, 8, -12, -1, -4, 14, -3, 0, 7, 9, 7, 12, 13, -9, 13, 11, -10, -10, -9, -10, 12, -10, 8,
                -5, 13, 11, -8, 7, -12, 0, -11, 2, -14, -8, 8, -3, 13, -9, 5, 5, 7, -11, -6, 5, -13, -7, 1, 14, -10, -1,
                -11, -13, 4, 12, -11, 2, 0, -4, -14, 4, 4, -10, 13, -3, -10, 6, 1, -12, 4, -9, 1, -4, -13, 10, 8, -11,
                10, -14, -12, -14, 1, -8, 10, -10, 11, -15, 0, -3, -12, 1, -14, -1, -1, 6, 11, -4, -3, -2, -1, -13 };
        List<List<Integer>> res = tSum.threeSum_1(nums);
        output(res);
    }

    private void output(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (Integer v : list) {
                System.out.print(v + " ");
            }
            System.out.println("");
        }
    }
}
