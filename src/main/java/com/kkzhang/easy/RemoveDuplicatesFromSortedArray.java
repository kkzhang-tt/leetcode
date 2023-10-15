package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&id=top-interview-150
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * 解题思路：
     * 题目要求原地删除有序数组中的重复元素，并返回删除后数组的新长度。我们可以使用双指针的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 使用两个指针，一个指针 i 从数组的第二个元素开始遍历，另一个指针 j 用于记录非重复元素的位置。
     * 2. 遍历数组，当当前元素与前一个元素相等时，指针 i 向后移动一位。
     * 3. 当当前元素与前一个元素不相等时，将该元素复制到指针 j 的位置，并同时移动指针 i 和 j。
     * 4. 重复步骤 2 和 3，直到遍历完整个数组。
     * 5. 返回指针 j 加 1 的值，即为新数组的长度。
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 1; // 遍历指针
        int j = 1; // 非重复元素的位置指针

        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 1; // 遍历指针
        int j = 1; // 非重复位置指针
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
