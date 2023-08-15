package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    // 开区间
    // 注意越界情况
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
    // 闭区间
    /**
     * int binarySearchFirst(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 注意这里使用开区间，右边界是数组长度
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid; // 缩小右边界，继续往左边查找
                } else {
                    left = mid + 1;
                }
            }
            return left; // 返回第一个满足条件的元素位置
    }
     * 
     */

    // 开区间；注意越界
    // 为什么返回 left -1 ?
    // 因为 left 的更新必须是 left = mid + 1 ，就是说 while 循环结束 时， nums[left] 一定不等于 target 了，
    // 而 nums[left-1] 可能是 target
    private int findLast(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        if (left == 0 || nums[left] != target) {
            return -1;
        }
        return left - 1;
    }

    // 闭区间
    /**
     * int binarySearchLast(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1; // 缩小左边界，继续往右边查找
                }
            }
            return left - 1; // 返回最后一个满足条件的元素位置
        }
     */

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return res;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int l = mid;
                int r = mid;
                // expand left and right
                while (l >= 0 && nums[l] == target) {
                    res[0] = l;
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    res[1] = r;
                    r++;
                }
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
