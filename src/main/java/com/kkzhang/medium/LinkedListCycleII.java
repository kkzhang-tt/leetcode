package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        // fist meet
        while (fast != null && slow != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // no cycle
                return null;
            }

            if (slow == fast) {
                // the node where they meet
                break;
            }
        }
        // second meet
        fast = head;
        while (slow != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
