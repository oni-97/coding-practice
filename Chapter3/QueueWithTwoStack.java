package Chapter3;

public class QueueWithTwoStack<T> {
    public static void main(String[] args) {
        QueueWithTwoStack<Integer> q = new QueueWithTwoStack<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

    MyStack<T> stack;
    MyStack<T> queue;

    public QueueWithTwoStack() {
        stack = new MyStack<T>();
        queue = new MyStack<T>();
    }

    public void add(T item) {
        stack.push(item);
    }

    public T remove() {
        if (queue.isEmpty()) {
            moveStack(stack, queue);
        }
        return queue.pop();
    }

    public void moveStack(MyStack<T> s1, MyStack<T> s2) {
        while (!s1.isEmpty()) {
            T item = s1.pop();
            s2.push(item);
        }
    }
}
