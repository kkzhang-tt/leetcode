package com.kkzhang.easy;

import com.kkzhang.common.ListNode;
import org.junit.Test;

public class RemoveLinkedListElementsTest {
    private RemoveLinkedListElements solution = new RemoveLinkedListElements();

    @Test
    public void testRemoveLinkedListElements(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = solution.removeElements(node1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
