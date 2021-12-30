package graph;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Weiyan Xiang on 2021/12/30
 */
public class MiniKnightMovesTest {
    @Test
    public void testMoves() {
        assertThat(new MiniKnightMoves().minKnightMoves(2, 1), is(1));
        assertThat(new MiniKnightMoves().minKnightMoves(5, 5), is(4));
    }

}