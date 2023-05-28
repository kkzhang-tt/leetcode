package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&id=top-interview-150
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * 解题思路：
     * 题目要求原地删除有序数组中重复出现的元素，且每个元素最多出现两次。我们可以使用双指针的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 使用两个指针，一个指针 i 从数组的第三个元素开始遍历，另一个指针 j 用于记录有效元素的位置。
     * 2. 遍历数组，当当前元素与前两个元素相等时，指针 i 向后移动一位。
     * 3. 当当前元素与前两个元素不相等时，将该元素复制到指针 j 的位置，并同时移动指针 i 和 j。
     * 4. 重复步骤 2 和 3，直到遍历完整个数组。
     * 5. 返回指针 j 加 1 的值，即为新数组的长度。
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2; // 遍历指针
        int j = 2; // 有效元素的位置指针
        while (i < nums.length) {
            if (nums[i] != nums[j - 1] || nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
