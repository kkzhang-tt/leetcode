package com.kkzhang.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * 与 116 解法相同
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;

        while (!queue.isEmpty()) {
            // current level size
            int size = queue.size();

            Node curLevelHead = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                // assemble the nodes of the current level into a linked list
                if (curLevelHead != null) {
                    curLevelHead.next = cur;
                }
                curLevelHead = cur;
            }
            curLevelHead.next = null;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
