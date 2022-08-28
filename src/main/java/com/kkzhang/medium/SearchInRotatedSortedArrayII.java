package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[mid] <= nums[right]) { // mid 右侧有序
                if (nums[mid] < target && nums[right] >= target) {
                    // target 在 mid 右侧
                    left = mid + 1;
                } else {
                    // target 在 mid 左侧
                    right = mid - 1;
                }
            } else { // mid 左侧有序
                if (nums[mid] > target && nums[left] <= target) {
                    // target 在 mid 左侧
                    right = mid - 1;
                } else {
                    // target 在 mid 右侧
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
