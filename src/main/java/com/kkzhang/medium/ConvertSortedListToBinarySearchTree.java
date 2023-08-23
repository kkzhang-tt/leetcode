package com.kkzhang.medium;

import com.kkzhang.common.ListNode;
import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 解题思路：
     * 与将有序数组转换为平衡二叉搜索树类似，这里需要将有序链表转换为平衡二叉搜索树。
     * 由于链表不支持常数时间的随机访问，所以不能像数组那样直接获取中间元素。
     * 但是可以利用递归的方式，每次找到链表的中间节点作为根节点，然后递归构建左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 使用快慢指针的方式找到链表的中间节点，将其作为当前子树的根节点。
     * 2. 将链表分成两部分，左边部分用于构建左子树，右边部分用于构建右子树。
     * 3. 递归地构建左子树和右子树。
     * 4. 返回根节点。
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode midNode = findMidAndBreak(head);
        TreeNode root = new TreeNode(midNode.val);

        if (midNode == head) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);

        return root;

    }

    private ListNode findMidAndBreak(ListNode node) {
        ListNode slow = node, fast = node, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

    /**
     * public class Solution {
     * public TreeNode sortedListToBST(ListNode head) {
     * if(head==null) return null;
     * return toBST(head,null);
     * }
     * 
     * public TreeNode toBST(ListNode head, ListNode tail){
     * ListNode slow = head;
     * ListNode fast = head;
     * if(head==tail) return null;
     * 
     * while(fast!=tail&&fast.next!=tail){
     * fast = fast.next.next;
     * slow = slow.next;
     * }
     * TreeNode thead = new TreeNode(slow.val);
     * thead.left = toBST(head,slow);
     * thead.right = toBST(slow.next,tail);
     * return thead;
     * }
     */
}
