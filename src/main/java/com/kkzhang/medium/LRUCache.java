package com.kkzhang.medium;

import java.util.HashMap;
import java.util.Map;

import com.kkzhang.common.Node;

/**
 * https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
 */
public class LRUCache {
    /**
     * 解题思路：
     * LRU缓存是基于最近最少使用原则进行数据替换的缓存结构。为了实现LRU缓存，我们可以使用哈希表和双向链表的结合来存储缓存数据。
     * 
     * 具体步骤如下：
     * 1. 使用哈希表 HashMap<Integer, Node> 存储缓存数据。其中，键为缓存的键，值为双向链表中对应的节点。
     * 2. 使用双向链表 LinkedList<Node> 存储缓存数据的顺序。链表的头部表示最近使用的缓存，尾部表示最久未使用的缓存。
     * 3. 定义一个内部类 Node，表示双向链表的节点。每个节点包括键、值和前后指针。
     * 4. 当执行 get 操作时，如果键存在于哈希表中，就将对应的节点移动到链表的头部，并返回节点的值。
     * 5. 当执行 put 操作时，如果键存在于哈希表中，就更新对应的节点的值，并将节点移动到链表的头部。
     * * 如果缓存容量已满，就删除链表尾部的节点，并从哈希表中删除对应的键。
     * * 创建新的节点，将其插入链表的头部，并将对应的键值对存入哈希表中。
     * 
     * @param capacity
     */
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addHead(node);
        } else {
            node.val = value;
            removeNode(node);
            addHead(node);
        }
        if (map.size() > capacity) {
            Node n = removeTail();
            map.remove(n.key);
        }
    }

    private void addHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;

        next.pre = node;
        node.next = next;
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
