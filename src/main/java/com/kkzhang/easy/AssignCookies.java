package com.kkzhang.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 */
public class AssignCookies {
    // 贪心算法
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            // 每次都先满足最容易满足的孩子
            // 贪心策略：给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
