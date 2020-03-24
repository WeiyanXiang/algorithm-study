/**
 *
 */
package data.structure;

/**
 * @author weiyan.xiang
 * @date 23 Jan 2018
 */
public class StackImpl {
    private int top;
    private String[] memory;
    private int size;

    /**
     * @param size
     */
    public StackImpl(int size) {
        this.top = -1;
        this.size = size;
        this.memory = new String[size];
    }

    public String pop() {
        return this.memory[top--];
    }

    public String peek() {
        return this.memory[top];
    }

    public String push(String s) {
        this.memory[++top] = s;
        return s;
    }

    public static void main(String[] args) {
        StackImpl testObj = new StackImpl(12);
        testObj.push("1");
        testObj.push("2");
        testObj.push("3");
        System.out.println(testObj.peek());
        System.out.println(testObj.pop());
        System.out.println(testObj.pop());
    }

}
