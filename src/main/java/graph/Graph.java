package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/10/6
 */
public class Graph {
    public int v;
    public List[] adj;

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
