package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] <= nums[right]) { // mid 右侧有序
                if (nums[mid] < target && target <= nums[right]) {
                    // target 在 mid 右侧
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // mid 左侧有序
                if (nums[mid] > target && nums[left] <= target) {
                    // target 在 mid 左侧
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
