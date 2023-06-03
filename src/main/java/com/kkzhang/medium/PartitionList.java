package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/partition-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class PartitionList {
    /**
     * 解题思路：
     * 这道题可以通过创建两个新链表来实现。一个链表用于存储所有小于 x 的节点，另一个链表用于存储所有大于或等于 x
     * 的节点。然后将两个链表连接起来，形成最终的链表。
     * 
     * 具体步骤如下：
     * 1. 创建两个虚拟头节点 dummyHead1 和 dummyHead2，分别用于存储小于 x 的节点和大于或等于 x 的节点。
     * 2. 定义两个指针 curr1 和 curr2，分别指向两个新链表的当前节点。
     * 3. 遍历原链表，将小于 x 的节点连接到 dummyHead1 链表，大于或等于 x 的节点连接到 dummyHead2 链表。
     * 4. 遍历结束后，将 dummyHead1 的尾节点连接到 dummyHead2 的头节点，形成最终的链表。
     * 5. 返回 dummyHead1 的下一个节点，即为最终链表的头节点。
     * 
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(0);
        ListNode curLess = dummyLess;
        ListNode dummyGreater = new ListNode(0);
        ListNode curGreater = dummyGreater;

        while (head != null) {
            if (head.val < x) {
                curLess.next = head;
                curLess = curLess.next;
            } else {
                curGreater.next = head;
                curGreater = curGreater.next;
            }
            head = head.next;
        }
        curGreater.next = null;
        curLess.next = dummyGreater.next;
        return dummyLess.next;
    }
}
