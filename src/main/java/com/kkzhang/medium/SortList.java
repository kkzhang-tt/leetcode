package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {
    /**
     * 解题思路：
     * 要对链表进行排序，可以使用归并排序的思想。
     * 归并排序的关键是将链表分成两个子链表，对每个子链表进行递归排序，然后将排好序的子链表合并成一个有序链表。
     * 
     * 具体步骤如下：
     * 使用快慢指针找到链表的中点，将链表分成两个子链表。
     * 递归对两个子链表进行排序。
     * 合并两个有序子链表，得到最终的有序链表。
     * 
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 边界条件判断
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割链表
        ListNode rightHead = slow.next;
        slow.next = null;

        // 递归对左右两个子链表进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两个有序链表
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // 将剩余的节点接到已排序的链表末尾
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
}
