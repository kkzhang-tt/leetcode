package com.kkzhang.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int v; // 顶点数目
    private int e; // 边数目
    private List<Integer>[] adj; // 邻接表

    // 创建一个含有 v 个顶点但是不含边的图
    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new ArrayList[v];
        // 初始化邻接表
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    // 顶点数
    public int V() {
        return v;
    }

    // 边数
    public int E() {
        return e;
    }

    // 向图中添加一条边 v-w
    public void addEdge(int v, int w) {
        // 将 w 添加到 v 的链表中
        adj[v].add(w);
        // 将 v 添加到 w 的链表中
        adj[w].add(v);
        this.e++;
    }

    // 与 v 相邻的所有顶点
    public List<Integer> adj(int v) {
        return adj[v];
    }

    // 图的字符串表示
    public String toString() {
        String s = v + " vertices, " + e + " edges \n";
        for (int v = 0; v < this.v; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
