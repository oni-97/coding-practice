package Chapter3;

public class MyStackWithMin2 extends MyStack<Integer> {

    public static void main(String[] args) {
        MyStackWithMin stack = new MyStackWithMin();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.pop() + " " + stack.min());
        System.out.println(stack.pop() + " " + stack.min());
    }

    MyStack<Integer> minStack;

    public MyStackWithMin2() {
        minStack = new MyStack<Integer>();
    }

    public void push(int item) {
        if (item <= min())
            minStack.push(item);
        super.push(item);
    }

    public Integer pop() {
        int item = super.pop();
        if (item == min())
            minStack.pop();
        return item;
    }

    public int min() {
        if (minStack.isEmpty())
            return Integer.MAX_VALUE;
        else
            return minStack.peek();
    }
}
