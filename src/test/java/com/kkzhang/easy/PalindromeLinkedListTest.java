package com.kkzhang.easy;

import com.kkzhang.common.ListNode;
import org.junit.Test;

public class PalindromeLinkedListTest {
    private PalindromeLinkedList solution = new PalindromeLinkedList();

    @Test
    public void testPalindromeLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        boolean res = solution.isPalindrome(node1);
        System.out.print(res);
    }
}
