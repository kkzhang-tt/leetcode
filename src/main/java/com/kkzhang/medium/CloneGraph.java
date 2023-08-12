package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    /**
     * 解题思路：
     * 这道题是图的深度优先遍历（DFS）的应用。
     * 首先需要理解图的表示方式，每个节点都包含一个值 val 和一个邻居列表 neighbors。
     * 我们可以使用哈希表来存储已经创建的节点，从而避免重复创建。
     * 
     * 具体步骤如下：
     * 1. 创建一个哈希表 visited，用于存储已经创建的节点。键是原始图中的节点，值是复制后的节点。
     * 2. 创建一个深度优先搜索（DFS）方法 cloneNode，接受一个节点 node 作为参数。
     * * 2.1 首先检查 visited 中是否已经存在该节点的复制版本，如果存在则直接返回，否则创建一个新的节点。
     * * 2.2 在 visited 中将原始节点和新创建的节点进行映射。
     * * 2.3 遍历原始节点的邻居列表，对每个邻居，递归调用 cloneNode 方法，并将其加入新节点的邻居列表中。
     * * 2.4 返回新节点。
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);

    }

    public Node dfs(Node node, Map<Node, Node> visited) {
        // if copied, return copy
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // copy the current node
        ArrayList<Node> copyNeighbors = new ArrayList<>();
        Node copy = new Node(node.val, copyNeighbors);
        visited.put(node, copy);

        // copy the neighbors of the current node
        for (Node neighbor : node.neighbors) {
            Node copyNeighbor = dfs(neighbor, visited);
            copyNeighbors.add(copyNeighbor);
        }

        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
