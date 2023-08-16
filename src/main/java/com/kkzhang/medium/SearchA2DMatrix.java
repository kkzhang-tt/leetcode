package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    /**
     * 解题思路：
     * 由于矩阵的每一行都是升序排列的，可以将矩阵视为一个有序数组，然后使用二分搜索来判断目标值是否存在。
     * 
     * 具体步骤如下：
     * 1. 将二维矩阵展开为一个有序的一维数组，可以将行与行之间的分割线忽略，将整个矩阵视为一个有序数组。
     * 2. 使用二分搜索在一维数组中寻找目标值。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / cols][mid % cols];
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
