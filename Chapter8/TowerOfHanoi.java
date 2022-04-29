package Chapter8;

import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        solveTowerOfHanoi(1);
        solveTowerOfHanoi(3);
        solveTowerOfHanoi(5);
        solveTowerOfHanoi(0);
    }

    static void solveTowerOfHanoi(int n) {
        if (n <= 0)
            return;
        Stack<Integer> t1 = new Stack<>();
        Stack<Integer> t2 = new Stack<>();
        Stack<Integer> t3 = new Stack<>();
        for (int i = n; i > 0; i--) {
            t1.push(i);
        }
        move(t1, t3, t2, n);
        System.out.println("solved");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
    }

    static void move(Stack<Integer> from, Stack<Integer> to, Stack<Integer> tmp, int n) {
        if (n == 1) {
            int top = from.pop();
            to.push(top);
            return;
        }
        move(from, tmp, to, n - 1);
        move(from, to, tmp, 1);
        move(tmp, to, from, n - 1);
    }
}
