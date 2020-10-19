package data.structure.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2020/10/18
 */
public class DynamicArrayTest {

    private DynamicArray testObj;

    @Test
    public void getAndSet() {
        testObj = new DynamicArray(4);

        testObj.set(0, "a");
        testObj.set(1, "b");
        testObj.set(2, "c");

        assertEquals("c", testObj.get(2));
    }


    @Test
    public void insert() {
        testObj = new DynamicArray(2);

        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        testObj.insert(1, "B!!!");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testObj.insert(8, "B!!!"));
        assertEquals("B!!!", testObj.get(1));

    }

    @Test
    public void delete() {
        testObj = new DynamicArray(2);

        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        testObj.delete(1);
        assertEquals("a", testObj.get(0));
        assertEquals("c", testObj.get(1));


    }

    @Test
    public void isEmpty() {
        testObj = new DynamicArray(2);

        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        assertFalse(testObj.isEmpty());

        testObj = new DynamicArray(2);
        assertTrue(testObj.isEmpty());
    }

    @Test
    public void contains() {
        testObj = new DynamicArray(2);

        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        assertTrue(testObj.contains("b"));
        assertFalse(testObj.contains("e"));

    }

    @Test
    public void size() {
        testObj = new DynamicArray(2);
        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        assertEquals(3, testObj.size());
    }

    @Test
    public void add() {
        testObj = new DynamicArray(2);
        testObj.add("a");
        testObj.add("b");
        testObj.add("c");

        assertEquals("b", testObj.get(1));
    }
}