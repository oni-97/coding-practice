package Chapter8;

public class TrippleStep {
    static int trippleStep(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 2;
        for (int i = 0; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }
}
