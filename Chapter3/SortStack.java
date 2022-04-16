package Chapter3;

public class SortStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(6);
        stack.push(7);
        sortStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static void sortStack(MyStack<Integer> stack) {
        MyStack<Integer> subStack = new MyStack<>();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            while (!subStack.isEmpty() && value < subStack.peek()) {
                stack.push(subStack.pop());
            }
            subStack.push(value);
        }

        while (!subStack.isEmpty()) {
            stack.push(subStack.pop());
        }
    }
}
