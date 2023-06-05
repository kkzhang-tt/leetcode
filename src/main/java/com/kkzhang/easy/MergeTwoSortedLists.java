package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    /**
     * 解题思路：
     * 这道题可以使用迭代的方式来合并两个有序链表。
     * 
     * 具体步骤如下：
     * 1. 创建一个新的链表 dummyHead 作为结果链表的头节点，并用一个指针 curr 指向 dummyHead。
     * 2. 定义两个指针 p 和 q，分别指向两个输入链表的头节点。
     * 3. 进入循环，循环条件是 p 不为 null 且 q 不为 null：
     * * 比较 p 和 q 的节点值，将较小的节点连接到 curr 的后面，并更新指针 curr 和指针 p 或 q。
     * 4. 循环结束后，如果还有剩余的节点，将剩余的节点连接到 curr 的后面。
     * 5. 返回结果链表的头节点 dummyHead.next。
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

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
