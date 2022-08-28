package com.kkzhang.easy;

import com.kkzhang.common.ListNode;
import org.junit.Test;

public class ReverseLinkedListTest {
    private ReverseLinkedList solution = new ReverseLinkedList();

    @Test
    public void testReverseLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = solution.reverseList(node1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
