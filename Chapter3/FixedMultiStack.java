package Chapter3;

public class FixedMultiStack {
    public static void main(String[] args) throws Exception {
        FixedMultiStack stacks = new FixedMultiStack(3);
        stacks.push(0, 1);
        stacks.push(1, 11);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(1, 12);
        stacks.push(2, 21);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));
    }

    private int numberOfStacks = 3;
    private int capacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int capacity) {
        this.capacity = capacity;
        values = new int[capacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int data) throws Exception {
        if (isFull(stackNum))
            throw new Exception();
        values[capacity * stackNum + sizes[stackNum]] = data;
        sizes[stackNum]++;
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum))
            throw new Exception();
        sizes[stackNum]--;
        return values[capacity * stackNum + sizes[stackNum]];
    }

    boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    boolean isFull(int stackNum) {
        return sizes[stackNum] == capacity;
    }
}
