package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    /**
     * 解题思路：
     * 使用快慢指针可以判断链表中是否存在环。快指针每次移动两个节点，慢指针每次移动一个节点。
     * 如果链表中存在环，快指针最终会追上慢指针，即两个指针会相遇。
     * 如果链表中不存在环，快指针最终会到达链表的末尾，即快指针会指向null。
     * 
     * 具体步骤如下：
     * 1. 初始化快指针 fast 和慢指针 slow，分别指向链表的头节点 head。
     * 2. 进入循环，循环条件是 fast 不为 null 且 fast.next 不为 null：
     * * fast 指针每次向后移动两个节点，即 fast = fast.next.next。
     * * slow 指针每次向后移动一个节点，即 slow = slow.next。
     * * 如果 fast 和 slow 相等，说明链表中存在环，返回 true。
     * 3. 循环结束后，说明链表中不存在环，返回 false。
     * 
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

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
