package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveNthNodeFromEndofList {
    /**
     * 解题思路：
     * 这道题可以使用双指针来解决，一个指针先移动 n+1 步，然后两个指针一起移动，直到第一个指针到达链表末尾。此时，第二个指针指向倒数第 n
     * 个节点的前一个节点，我们将其 next 指针指向 next.next，即可删除倒数第 n 个节点。
     * 
     * 具体步骤如下：
     * 1. 创建一个虚拟头节点 dummyHead，将其指向原链表的头节点。
     * 2. 定义两个指针 fast 和 slow，初始时都指向 dummyHead。
     * 3. 将指针 fast 先向前移动 n+1 步。
     * 4. 同时移动指针 fast 和 slow，直到 fast 指向链表末尾。
     * 5. 将指针 slow 的 next 指针指向 slow 的下一个节点的下一个节点，即删除倒数第 n 个节点。
     * 6. 返回虚拟头节点 dummyHead 的下一个节点。
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode next = slow.next.next;
        slow.next = next;

        return dummy.next;
    }
}
