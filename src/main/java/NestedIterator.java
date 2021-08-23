import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Queue<Integer> list = new LinkedList<>();

    /**
     * 341. Flatten Nested List Iterator
     * <p>
     * https://leetcode.com/problems/flatten-nested-list-iterator/
     * <p>
     * my ac ans, just dfs
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        flat(nestedList);
    }

    private void flat(List<NestedInteger> nest) {
        for (NestedInteger ele : nest) {
            if (ele.isInteger()) {
                list.add(ele.getInteger());
            } else {
                flat(ele.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.poll();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}


