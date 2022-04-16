package Chapter3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public MyStack() {
        size = 0;
    }

    private StackNode<T> top;
    int size;
    int MAX_SIZE = 10;

    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size > MAX_SIZE;
    }
}
