package com.kkzhang.easy;

import java.util.List;

import org.junit.Test;

public class PascalsTriangleIITest {
    private PascalsTriangleII solution = new PascalsTriangleII();

    @Test
    public void testPascalsTriangleII() {
        int rowIndex = 3;
        List<Integer> res = solution.getRow(rowIndex);
        output(res);
    }

    private void output(List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
