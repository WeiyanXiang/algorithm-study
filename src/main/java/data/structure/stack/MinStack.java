package data.structure.stack;

/**
 * @author Weiyan Xiang on 2020/6/23
 */
public class MinStack {

    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(10);
        s.push(25);
        s.push(15);
        s.push(7);
        s.push(28);
        s.push(30);

        System.out.println("7 == " + s.getMin());
        s.pop();
        s.pop();
        s.pop();
        System.out.println("10 == " + s.getMin());
    }

}