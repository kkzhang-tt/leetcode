package com.kkzhang.hard;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {

    /*
     * 解题思路：
     * 这是一个数组操作的问题。
     * 1. 首先，我们可以将数组中所有小于等于0的数以及大于数组长度的数都设置为一个不影响答案的数，比如说将它们设为数组长度加一。
     * 2. 然后，遍历数组，将每个元素对应的位置的数取负数。这样，如果数组中出现了正数x，那么x对应位置的数就是负数。
     * 3. 最后，再次遍历数组，找到第一个正数对应的位置，返回位置加一即可。
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (index <= n) {
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // chagpt generation
    /**
     * public class FirstMissingPositive {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Step 1: 将所有小于等于0的数以及大于数组长度的数设为n+1
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }

            // Step 2: 将每个元素对应的位置的数取负数
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }

            // Step 3: 找到第一个正数对应的位置，返回位置加一
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            return n + 1;
        }
    }
     */
}
