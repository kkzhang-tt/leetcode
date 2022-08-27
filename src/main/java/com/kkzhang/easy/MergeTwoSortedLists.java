package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode();
        ListNode curNode = preHead;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) { // 两个链表都不为空
                if (list1.val <= list2.val) {
                    curNode.next = list1;
                    list1 = list1.next;
                } else {
                    curNode.next = list2;
                    list2 = list2.next;
                }

            } else if (list1 == null) { // 链表 1 为空
                curNode.next = list2;
                break;
            } else { // 链表 2 为空
                curNode.next = list1;
                break;
            }
            curNode = curNode.next;
        }
        return preHead.next;
    }
}
