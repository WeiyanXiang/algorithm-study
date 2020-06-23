package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/6/20
 */
public class BFSTraverse {
    static class Graph {
        int v;
        List[] adj;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }
    }


}
