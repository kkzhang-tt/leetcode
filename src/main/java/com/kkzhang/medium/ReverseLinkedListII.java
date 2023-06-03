package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = left; i < right; i++) {
            ListNode next = cur.next;

        }
    }
}
