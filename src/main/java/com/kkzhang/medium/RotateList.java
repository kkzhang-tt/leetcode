package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateList {
    /**
     * 具体步骤如下：
     * 1. 如果链表为空或者链表只有一个节点，直接返回链表。
     * 2. 计算链表的长度，同时将链表的尾节点连接到头节点，形成一个环状链表。
     * 3. 计算旋转位置 k，如果 k 大于链表长度，则取 k 除以链表长度的余数。
     * 4. 根据旋转位置 k，找到新的链表头和链表尾。
     * * 新的链表头：从链表头节点出发，向右移动链表长度减去 k 步。
     * * 新的链表尾：新的链表头的前一个节点。
     * 5. 将链表尾的下一个节点置为 null，断开环状链表。
     * 6. 返回新的链表头。
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
