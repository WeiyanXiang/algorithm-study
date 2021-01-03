package search;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Weiyan Xiang on 2021/1/3
 */
public class Matrix01Test {

    @Test
    public void updateMatrix() {

        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };

        Matrix01 testObj = new Matrix01();
        // act
        int[][] actual = testObj.updateMatrix(matrix);
        // assert
        /**
         * [[0,0,0],
         *  [0,1,0],
         *  [1,2,1]]
         */
        int[][] expected = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1},
        };
        assertArrayEquals(expected, actual);
    }
}