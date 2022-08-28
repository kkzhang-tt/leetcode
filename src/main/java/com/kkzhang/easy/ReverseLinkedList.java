package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }
}
