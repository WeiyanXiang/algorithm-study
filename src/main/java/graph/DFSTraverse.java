package graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/20
 * <p>
 * https://www.baeldung.com/java-depth-first-search
 */
public class DFSTraverse {

    private static Graph g;

    // from a given source v
    static void dfs(int v) {
        boolean visited[] = new boolean[10];

        Stack<Integer> s = new Stack<>();
        s.add(v);

        visited[v] = true;
        while (!s.isEmpty()) {
            int c = s.pop();
            System.out.println("Visited node: " + c);
            LinkedList<Integer> ajList = g.adj[c];
            for (int i = 0; i < ajList.size(); i++) {
                int n = ajList.get(i);
                if (!visited[n]) {
                    s.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        g = new Graph(8);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 7);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        dfs(1);
    }

}
