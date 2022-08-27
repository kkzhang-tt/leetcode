package com.kkzhang.easy;

import com.kkzhang.util.ListNode;
import org.junit.Test;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    public void testMergeTwoSortedLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        solution.mergeTwoLists(node1, node4);
    }
}
