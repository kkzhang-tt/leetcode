package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/remove-element/?envType=study-plan-v2&id=top-interview-150
 */
public class RemoveElement {
    /**
     * 解题思路：
     * 题目要求原地删除数组中的指定元素，且返回新数组的长度。我们可以使用双指针的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 使用两个指针，一个指针 i 从数组的头部开始遍历，另一个指针 j 用于记录非指定元素的位置。
     * 2. 遍历数组，当数组的元素等于指定值时，指针 i 向后移动一位。
     * 3. 当数组的元素不等于指定值时，将该元素复制到指针 j 的位置，并同时移动指针 i 和 j。
     * 4. 重复步骤 2 和 3，直到遍历完整个数组。
     * 5. 返回指针 j 的值，即为新数组的长度。
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0; // 遍历指针
        int j = 0; // 非指定元素的位置指针
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
