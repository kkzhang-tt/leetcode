package com.kkzhang.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

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

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）的方法来解决。
     * 我们可以使用一个队列来存储每一层的节点，然后根据队列中的节点构建每个节点的 next 指针。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回根节点。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 进入循环，当队列不为空时，执行以下操作：
     * * 3.1 获取当前层的节点数量 size。
     * * 3.2 遍历当前层的所有节点，对于每个节点，将其 next 指向队列中的下一个节点。
     * * * * 如果是当前层的最后一个节点，则将其 next 指向 null。
     * * 3.3 将节点的左子节点和右子节点加入队列。
     * 4. 返回根节点。
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
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
