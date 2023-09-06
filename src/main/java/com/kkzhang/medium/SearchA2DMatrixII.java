package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class SearchA2DMatrixII {

    /**
     * 解题思路：
     * 由于矩阵的每行和每列都是升序排列的，可以使用一种高效的方法来搜索目标值。
     * 
     * 具体思路如下：
     * 1. 从矩阵的右上角开始（或左下角也可以），可以观察到一个性质：该位置的元素是该行中的最大值和该列中的最小值。
     * 2. 如果目标值比当前位置的元素小，由于当前元素是该列中的最小值，所以目标值不可能存在于该列中，可以向左移动一列，即 col--。
     * 3. 如果目标值比当前位置的元素大，由于当前元素是该行中的最大值，所以目标值不可能存在于该行中，可以向下移动一行，即 row++。
     * 4. 重复上述步骤，直到找到目标值或者越界（即 row 或 col 超出矩阵的边界）。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    // 该方法不能通过全部用例
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rowLeft = 0, colLeft = 0;
        int rowRight = matrix.length - 1, colRight = matrix[0].length - 1;

        while (rowLeft <= rowRight && colLeft <= colRight) {
            int midRow = rowLeft + (rowRight - rowLeft) / 2;
            int midCol = colLeft + (colRight - colLeft) / 2;

            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] > target) {
                rowRight = midRow - 1;
                colRight = midCol - 1;
            } else {
                rowLeft = midRow + 1;
                colLeft = midCol + 1;
            }
        }
        return false;
    }

}
