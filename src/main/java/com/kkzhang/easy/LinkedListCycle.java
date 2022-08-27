package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null) {
            // 快指针每次走两步
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            // 慢指针每次走一步
            slow = slow.next;
            // 快慢指针相遇，则存在环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
