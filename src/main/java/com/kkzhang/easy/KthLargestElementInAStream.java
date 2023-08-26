package com.kkzhang.easy;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

    class KthLargest {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                queue.offer(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    // chagpt generation
    /**
     * 解题思路：
     * 这道题可以使用优先队列（最小堆）来实现。
     * 
     * 1. 首先，在初始化时，将数组中的前 k 个元素放入最小堆中。
     * 2. 然后，每次在添加元素时，如果堆的大小小于 k，直接将元素加入堆中；
     * 3. 如果堆的大小已经达到 k，比较新元素与堆顶元素的大小关系，如果新元素大于堆顶元素，则将堆顶元素出堆，新元素入堆。
     * * * 这样保证最小堆的大小始终为 k，堆顶元素就是第 k 大的元素。
     */
    /**
     * class KthLargest {
            private PriorityQueue<Integer> minHeap;
            private int k;
            
            public KthLargest(int k, int[] nums) {
                this.k = k;
                minHeap = new PriorityQueue<>();
                for (int num : nums) {
                    add(num);
                }
            }
            
            public int add(int val) {
                if (minHeap.size() < k) {
                    minHeap.offer(val);
                } else if (val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(val);
                }
                return minHeap.peek();
            }
        }
     */

}
