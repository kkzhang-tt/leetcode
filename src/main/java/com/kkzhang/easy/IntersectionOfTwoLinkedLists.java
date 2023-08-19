package com.kkzhang.easy;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenghtA = 0;
        ListNode dummyA = headA;
        while(dummyA != null){
            dummyA = dummyA.next;
            lenghtA++;
        }

        int lenghtB = 0;
        ListNode dummyB = headB;
        while(dummyB != null){
            dummyB = dummyB.next;
            lenghtB++;
        }

        if(lenghtA > lenghtB){
            int step = 0;
            while(step < lenghtA - lenghtB){
                headA = headA.next;
                step++;
            }
        }else if(lenghtB > lenghtA){
            int step = 0;
            while(step < lenghtB -lenghtA){
                headB = headB.next;
                step++;
            }
        }

        while(headA != headB && headA != null && headB != null){
            headA = headA.next;
            headB = headB.next;
        }

        return headA == null ? null : headA;
    }

    /**
     * chagtgpt generation
     * 一个比较巧妙的解法是使用双指针。
     * 1. 两个指针 pA 和 pB 分别从链表 A 和链表 B 的头部出发
     * 2. 当一个指针到达链表末尾时，将其指向另一个链表的头部，继续前进。
     * * * 如果两个链表长度相同，那么分别只走了一遍，直到相交点
     * * * 如果两个链表长度不同，那么分别走了两遍，第二遍时走到相交点
     * 
     * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;
            
            while (pA != pB) {
                pA = (pA != null) ? pA.next : headB;
                pB = (pB != null) ? pB.next : headA;
            }
            
            return pA;
        }
     */
}
