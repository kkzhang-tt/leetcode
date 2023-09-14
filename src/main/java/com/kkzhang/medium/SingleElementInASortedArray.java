package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInASortedArray {

    /**
     * 解题思路：
     * 这个问题可以通过二分查找来解决，要充分利用有序数组的特性。
     * 我们可以观察到，除了单一的元素，数组中的所有其他元素都是成对出现的。
     * 因此，单一元素的索引必然是一个奇数，因为(其之前的)成对元素的索引都是偶数。
     * 
     * 1. 我们可以使用二分查找来搜索单一元素的位置。在每一步中，我们计算中间索引 mid。
     * 2. 如果 mid 是偶数，那么与它相邻的下一个索引是 mid + 1。
     * 3. 如果 mid 是奇数，那么与它相邻的上一个索引是 mid - 1。
     * 4. 我们可以检查 nums[mid] 是否等于 nums[mid + 1]，如果相等，说明单一元素在后半部分，否则在前半部分。
     * 5. 通过不断缩小搜索范围，最终我们将找到单一元素的位置。
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 目标值肯定存在，为 nums[left]
        // 使用开区间，终止条件 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 确保 mid 是偶数，使得相邻的索引在 mid + 1
            if (mid % 2 == 1) {
                mid--;
            }

            // 检查 mid 与 mid + 1 是否相等
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // 单一元素在后半部分
            } else {
                right = mid; // 单一元素在前半部分
            }
        }
        return nums[left];
    }
}
