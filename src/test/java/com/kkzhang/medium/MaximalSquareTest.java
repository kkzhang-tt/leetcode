package com.kkzhang.medium;

import org.junit.Test;

public class MaximalSquareTest {
    
    private MaximalSquare solution = new MaximalSquare();

    @Test
    public void testMaximalSquare(){
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int max = solution.maximalSquare(matrix);
        System.out.print(max);
    }
}
