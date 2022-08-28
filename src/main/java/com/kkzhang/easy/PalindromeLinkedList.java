package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    // 先找到中间节点，之后反转后半部分，再比较前后部分是否是回文
    // 思路对，但是没有通过全部用例
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null && head.val == head.next.val) {
            return true;
        }
        // 1. find middle node
        ListNode slow = head;
        ListNode fast = head;
        int step = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            step++;
        }
        // 2. revert left part
        ListNode pre = null;
        ListNode cur = head;
        while (cur != slow) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        // 3. compare two part
        ListNode left = cur;
        ListNode right = slow;
        if (step % 2 != 0) {
            right = right.next;
        }
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        if (left == null && right == null) {
            return true;
        }
        return false;
    }
}
