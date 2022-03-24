package com.kkzhang.medium;

import org.junit.Test;

public class AddTwoNumbersTest {
    @Test
    public void testSolution_1() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2_1 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2_2 = new AddTwoNumbers.ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;
        AddTwoNumbers.ListNode res = AddTwoNumbers.addTwoNumbers_1(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    @Test
    public void testSolution_2() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2_1 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2_2 = new AddTwoNumbers.ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;
        AddTwoNumbers.ListNode res = AddTwoNumbers.addTwoNumbers_1(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
