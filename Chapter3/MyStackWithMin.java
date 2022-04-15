package Chapter3;

import java.util.EmptyStackException;

public class MyStackWithMin {

    public static void main(String[] args) {
        MyStackWithMin stack = new MyStackWithMin();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.pop() + " " + stack.min());
        System.out.println(stack.pop() + " " + stack.min());
    }

    private static class StackNode {
        private int data;
        private StackNode next;
        private int min;

        public StackNode(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    private StackNode top;

    public int pop() {
        if (top == null)
            throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        int min = Math.min(min(), item);
        StackNode t = new StackNode(item, min);
        t.next = top;
        top = t;
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public int min() {
        if (top == null)
            return Integer.MAX_VALUE;
        return top.min;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
