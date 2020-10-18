package graph;

import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/10/6
 */
public class Graph {

    /**
     * 3 ways to represent a graph : 1. Edge list 2.  Adjacency Matrix 3.  Adjacency Lists
     * <p>
     * this is Adjacency Lists
     * <p>
     * refer more to notes
     */
    public int v;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
