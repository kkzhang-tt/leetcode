package com.kkzhang.medium;

import com.kkzhang.common.ListNode;
import org.junit.Test;

public class AddTwoNumbersTest {
    @Test
    public void testSolution_1() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;
        ListNode res = AddTwoNumbers.addTwoNumbers_1(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    @Test
    public void testSolution_2() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(9);
        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;
        ListNode res = AddTwoNumbers.addTwoNumbers_1(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
