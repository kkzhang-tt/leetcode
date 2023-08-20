package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    /**
     * 解题思路：
     * 要将一个链表重新排列为 L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 的形式，可以分为以下几个步骤：
     * 
     * 1. 使用快慢指针找到链表的中间节点，将链表分成两部分。
     * 2. 将后半部分链表进行反转。
     * 3. 将两个链表进行合并，一个节点从前半部分链表取，一个节点从反转后的后半部分链表取。
     * 
     * 具体步骤如下：
     * 1. 使用快慢指针找到链表的中间节点，将链表分成两部分。
     * 2. 反转链表的后半部分，即从中间节点的下一个节点开始反转。
     * 3. 将两个链表合并，一个节点从前半部分链表取，一个节点从反转后的后半部分链表取
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转链表的后半部分
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = null;

        ListNode head1 = head;
        ListNode head2 = pre;
        while (head2 != null) {
            // 交叉合并
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp1;
            head1 = tmp1;
            head2 = tmp2;
        }
    }
}
