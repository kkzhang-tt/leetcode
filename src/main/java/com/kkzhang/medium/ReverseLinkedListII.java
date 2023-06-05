package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseLinkedListII {
    /**
     * 解题思路：
     * 这道题要求反转链表中从第 m 个节点到第 n 个节点的部分。我们可以使用迭代的方式进行反转。
     * 
     * 具体步骤如下：
     * 1. 创建一个虚拟头节点 dummyHead，将其指向原链表的头节点。
     * 2. 定义一个指针 pre，指向 dummyHead，用于标记第 m-1 个节点。
     * 3. 将指针 cur 指向 pre 的下一个节点，即第 m 个节点。
     * 4. 使用一个循环，循环次数为 n-m，进行节点反转操作：
     * * 将指针 next 指向 cur 的下一个节点，用于保存下一个节点的引用。
     * * 将 cur 的下一个节点指向 next 的下一个节点，完成节点反转。
     * * 将 next 的下一个节点指向 pre 的下一个节点，将反转后的节点插入到 pre 和其后面节点之间。
     * 5. 返回虚拟头节点 dummyHead 的下一个节点。
     * 
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 该循环中，pre 指针指向的位置保持不变
        // cur 指针指向的节点往后移动，直到移动到目的位置
        ListNode cur = pre.next;
        for (int i = left; i < right; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
