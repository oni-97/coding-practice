package Chapter8;

public class RecurMultiple {
    public static void main(String[] args) {
        System.out.println(multiple(0, 20));
        System.out.println(multiple2(0, 20));
        System.out.println(multiple(1, 20));
        System.out.println(multiple2(1, 20));
        System.out.println(multiple(12, 25));
        System.out.println(multiple2(12, 25));
        System.out.println(multiple(11, 7));
        System.out.println(multiple2(11, 7));
    }

    static int multiple(int a, int b) {
        return recur(Math.min(a, b), Math.max(a, b), 0);
    }

    static int recur(int a, int b, int cur) {
        if (a == 0)
            return cur;
        cur = ((a & 1) != 0) ? cur + b : cur;
        return recur(a >>> 1, b << 1, cur);
    }

    static int multiple2(int a, int b) {
        return recur2(Math.min(a, b), Math.max(a, b));
    }

    static int recur2(int smaller, int larger) {
        if (smaller == 0)
            return 0;
        if (smaller == 1)
            return larger;

        int half = recur2(smaller >>> 1, larger);
        if (smaller % 2 == 0) {
            return half + half;
        } else {
            return half + half + larger;
        }
    }
}
