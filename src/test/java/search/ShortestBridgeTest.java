package search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2021/1/16
 */
public class ShortestBridgeTest {

    @Test
    public void shortestBridge() {
        ShortestBridge testObj = new ShortestBridge();
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };
        assertEquals(1, testObj.shortestBridge(matrix));
    }
}