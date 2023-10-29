package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            pre.next = cur;

            if (cur != null) {
                cur = cur.next;
            }
            pre = pre.next;
        }

        return dummy.next;
    }

    // chatgpt generation
    // 单指针
    /**
     * 解题思路：
     * 这是一个链表操作的问题。
     * 1. 首先，判断链表是否为空或者只有一个节点，如果是，则直接返回原链表。
     * 2. 创建一个指针 current，指向链表的头节点。
     * 3. 使用一个循环遍历链表，比较 current 节点的值与下一个节点的值是否相等。
     * 4. 如果相等，说明有重复元素，将 current 的 next 指针指向下一个节点的 next，即跳过重复元素。
     * 5. 如果不相等，将 current 移动到下一个节点。
     * 6. 重复步骤3至5，直到遍历完整个链表。
     * 7. 返回处理后的链表。
     */
    /**
     * public class RemoveDuplicatesFromSortedList {
            public ListNode deleteDuplicates(ListNode head) {
                if (head == null || head.next == null) {
                    return head;
                }
                
                ListNode current = head;
                
                while (current.next != null) {
                    if (current.val == current.next.val) {
                        current.next = current.next.next;
                    } else {
                        current = current.next;
                    }
                }
                
                return head;
            }
        }
     */
}
