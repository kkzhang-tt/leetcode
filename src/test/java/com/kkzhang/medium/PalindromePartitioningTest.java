package com.kkzhang.medium;

import java.util.List;

import org.junit.Test;

public class PalindromePartitioningTest {
    private PalindromePartitioning solution = new PalindromePartitioning();

    @Test
    public void testPalindromePartitioning() {
        String s = "aab";
        List<List<String>> res = solution.partition(s);
        output(res);
    }

    private void output(List<List<String>> res) {
        for (List<String> list : res) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
    }
}
