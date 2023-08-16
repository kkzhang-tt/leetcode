package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public int search3(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] >= nums[left]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 解题思路：
     * 这道题可以使用二分查找来解决。
     * 由于旋转数组中存在两个有序的子数组，我们可以通过二分查找来判断目标值在哪个子数组中，然后在该子数组中继续进行二分查找。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 left 为 0，right 为数组长度减 1。
     * 2. 进入循环，当 left 小于等于 right 时，执行以下操作：
     * * 计算中间位置 mid，为 (left + right) / 2。
     * * 如果中间位置的值等于目标值 target，直接返回 mid。
     * * 如果左半部分有序（即 nums[left] <= nums[mid]）：
     * * * 如果目标值在左半部分范围内（即 nums[left] <= target < nums[mid]），将 right 更新为 mid - 1。
     * * * 否则，将 left 更新为 mid + 1。
     * * 如果右半部分有序（即 nums[mid] <= nums[right]）：
     * * * 如果目标值在右半部分范围内（即 nums[mid] < target <= nums[right]），将 left 更新为 mid + 1。
     * * * 否则，将 right 更新为 mid - 1。
     * 3. 如果循环结束后仍然没有找到目标值，返回 -1。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] == nums[left]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right = mid - 1;
            } else if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

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
