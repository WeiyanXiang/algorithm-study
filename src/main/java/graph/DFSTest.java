package graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Weiyan Xiang on 2020/10/18
 */
public class DFSTest {

    private Graph g;

    @Before
    public void setUp() throws Exception {
        g = new Graph(8);
    }

    @Test
    public void testDFS() {
        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 6);
        g.addEdge(6, 0);
        g.addEdge(1, 5);
        g.addEdge(5, 3);
        g.addEdge(3, 0);
        g.addEdge(5, 2);
        g.addEdge(2, 7);

        // expected: 0,1,5,2,7,3,4,6 or similar
        DFS dfs = new DFS();
        dfs.doDfs(g, 0);
        System.out.println();
        dfs.doDfsIterative(g, 0);
    }
}