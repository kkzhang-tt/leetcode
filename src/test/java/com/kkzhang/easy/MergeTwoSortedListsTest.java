package com.kkzhang.easy;

import org.junit.Test;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    public void testMergeTwoSortedLists() {
        MergeTwoSortedLists.ListNode node1 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode node2 = new MergeTwoSortedLists.ListNode(2);
        MergeTwoSortedLists.ListNode node3 = new MergeTwoSortedLists.ListNode(4);
        node1.next = node2;
        node2.next = node3;

        MergeTwoSortedLists.ListNode node4 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode node5 = new MergeTwoSortedLists.ListNode(3);
        MergeTwoSortedLists.ListNode node6 = new MergeTwoSortedLists.ListNode(4);
        node4.next = node5;
        node5.next = node6;

        solution.mergeTwoLists(node1, node4);
    }
}
