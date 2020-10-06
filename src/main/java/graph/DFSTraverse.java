package graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/20
 */
public class DFSTraverse {

    private static Graph g;

    // from a given source v
    static void dfs(int v) {
        boolean visited[] = new boolean[v];

        Stack<Integer> s = new Stack<>();
        s.add(v);

        visited[v] = true;

        while (!s.isEmpty()) {
            int c = s.pop();

            Iterator<Integer> i = g.adj[c].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    s.push(n);
                    visited[n] = true;
                }
            }
        }

    }

    public static void main(String args[]) {
        g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        dfs(2);
    }

}
