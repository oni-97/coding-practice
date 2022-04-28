package Chapter8;

public class Fibonacci {
    int fibonacci1(int i) {
        if (i == 0 || i == 1)
            return i;
        return fibonacci1(i - 1) + fibonacci1(i - 2);
    }

    int fibonacci2(int n) {
        return fibonacci2(n, new int[n + 1]);
    }

    int fibonacci2(int i, int[] memo) {
        if (i == 0 || i == 1)
            return i;
        if (memo[i] == 0)
            memo[i] = fibonacci2(i - 1, memo) + fibonacci2(i - 2, memo);
        return memo[i];
    }

    int fibonacci3(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }

    int fibonacci4(int n) {
        if (n == 0 || n == 1)
            return n;

        int pre1 = 0;
        int pre2 = 1;
        for (int i = 2; i < n; i++) {
            int now = pre1 + pre2;
            pre1 = pre2;
            pre2 = now;
        }
        return pre1 + pre2;
    }
}
