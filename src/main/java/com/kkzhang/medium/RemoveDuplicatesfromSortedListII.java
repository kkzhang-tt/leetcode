package com.kkzhang.medium;

import com.kkzhang.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * 解题思路：
     * 这道题可以通过迭代的方式解决。使用两个指针 prev 和 curr，其中 prev 指向当前节点的前一个节点，curr
     * 指向当前节点。遍历链表，判断当前节点和下一个节点的值是否相同，如果相同，则继续向后遍历，直到找到不相同的节点或链表遍历完。然后，根据是否存在重复节点，更新
     * prev 和 curr 的指针，将重复节点删除。
     * 
     * 具体步骤如下：
     * 1. 创建一个虚拟头节点 dummyHead，将其指向原链表的头节点。
     * 2. 定义两个指针 prev 和 curr，初始时都指向 dummyHead。
     * 3. 进入循环，判断 curr 的下一个节点和下下个节点的值是否相同，如果相同，说明存在重复节点，继续向后遍历，直到找到不相同的节点或链表遍历完。
     * 4. 根据是否存在重复节点，更新 prev 和 curr 的指针，将重复节点删除。
     * 5. 返回虚拟头节点 dummyHead 的下一个节点。
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }
        return dummy.next;
    }
}
