package graph;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Weiyan Xiang on 2020/10/17
 */
public class BFSTest {

    private Graph g;

    @Before
    public void setUp() throws Exception {
        g = new Graph(8);
    }

    @Test
    public void testBFS() {
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 7);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        // expected: 1,3,5,7,4,6
        new BFS().doBfs(g, 1, 12);
    }
}