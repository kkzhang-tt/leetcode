package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {
    // 如果使用 map/set，空间复杂度为 O(n)
    // 采取类似链表环的快慢指针的方式
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // find the position they meet
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // find the entry of the cycle
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
