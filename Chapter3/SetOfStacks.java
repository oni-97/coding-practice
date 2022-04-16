package Chapter3;

import java.util.*;

public class SetOfStacks<T> extends MyStack<T> {
    public static void main(String[] args) {
        SetOfStacks<Integer> stack = new SetOfStacks<Integer>();
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    List<MyStack<T>> stacks;

    public SetOfStacks() {
        stacks = new ArrayList<MyStack<T>>();
        stacks.add(new MyStack<T>());
    }

    public MyStack<T> getLastStack() {
        if (stacks.size() == 0)
            return null;
        else
            return stacks.get(stacks.size() - 1);
    }

    public T pop() {
        MyStack<T> stack = getLastStack();
        if (stack == null)
            throw new EmptyStackException();

        T top = stack.pop();
        if (stack.isEmpty())
            stacks.remove(stacks.size() - 1);
        return top;
    }

    public T peek() {
        if (stacks.size() == 0)
            throw new EmptyStackException();

        MyStack<T> stack = stacks.get(stacks.size() - 1);
        T top = stack.peek();
        return top;
    }

    public void push(T item) {
        MyStack<T> stack = getLastStack();
        if (stack == null || stack.isFull()) {
            MyStack<T> st = new MyStack<T>();
            st.push(item);
            stacks.add(st);
        } else {
            stack.push(item);
        }
    }
}
