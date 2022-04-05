package com.kkzhang.easy;

import java.util.List;

import org.junit.Test;

public class PascalTriangleTest {
    private PascalTriangle solution = new PascalTriangle();
    @Test
    public void testPascalTriangle(){
        int numRows = 5;
        List<List<Integer>> res = solution.generate(numRows);
        output(res);
    }

    private void output(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (Integer v : list) {
                System.out.print(v + " ");
            }
            System.out.println(" ");
        }
    }
}
