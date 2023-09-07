package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInASortedMatrix {

    // 没有通过全部用例
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = 0, right = n * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == k - 1) {
                int row = mid / n;
                int col = mid % n;
                return matrix[row][col];
            } else if (mid > k - 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 解题思路：
     * 由于每行和每列元素均按升序排序，我们可以使用优先队列（最小堆）来解决这个问题。
     * 
     * 具体步骤如下：
     * 1. 初始化一个最小堆，将矩阵第一列的元素加入堆中，同时记录它们的行号和列号。
     * 2. 迭代执行以下操作 k - 1 次（因为第一个最小的元素已经在堆中）：
     * * 2.1 从堆中取出当前最小的元素 minElement，同时记录它的行号和列号。
     * * 2.2 如果该元素所在行还有下一个元素（即不是该列的最后一个元素），将下一个元素也加入堆中。
     * 3. 最终，堆顶元素即为第 k 小的元素。
     */
    /**
     * class Solution {
            public int kthSmallest(int[][] matrix, int k) {
                int n = matrix.length;
                PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
                
                for (int i = 0; i < n; i++) {
                    minHeap.offer(new int[]{i, 0});
                }
                
                for (int i = 0; i < k - 1; i++) {
                    int[] minElement = minHeap.poll();
                    int row = minElement[0];
                    int col = minElement[1];
                    if (col < n - 1) {
                        minHeap.offer(new int[]{row, col + 1});
                    }
                }
                
                int[] result = minHeap.poll();
                return matrix[result[0]][result[1]];
            }
        }
     */
}
