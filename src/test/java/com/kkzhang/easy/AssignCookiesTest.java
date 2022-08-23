package com.kkzhang.easy;

import org.junit.Test;

public class AssignCookiesTest {

    private AssignCookies solution = new AssignCookies();

    @Test
    public void testAssignCookies() {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        int count = solution.findContentChildren(g, s);
        System.out.print(count);
    }
}
