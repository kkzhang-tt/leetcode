package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    // 参考答案思路一致，不过代码更简洁
    // 不过当其中一个链表为空时，仍在遍历，导致耗时较大；并不是最优解
    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = carry + x + y;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode tmp = cur;

        int flag = 0;
        while (l1 != null && l2 != null) {
            int l1Value = l1.val;
            int l2Value = l2.val;

            int sum = l1Value + l2Value + flag;
            int sub = sum % 10;
            flag = sum / 10;
            cur.next = new ListNode(sub);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            merge(flag, cur, l2);
        }

        if (l2 == null) {
            merge(flag, cur, l1);
        }
        return tmp.next;
    }

    private static void merge(int flag, ListNode cur, ListNode remain) {
        while (remain != null) {
            if (flag == 0) {
                cur.next = remain;
                return;
            } else {
                int val = remain.val;
                int sum = val + flag;
                int sub = sum % 10;
                flag = sum / 10;
                cur.next = new ListNode(sub);
                cur = cur.next;
                remain = remain.next;
            }
        }
        if (flag != 0) {
            cur.next = new ListNode(flag);
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
