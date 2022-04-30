package Chapter8;

public class Coin {
    public static void main(String[] args) {
        System.out.println(getNumberOfCases(10));
    }

    static int getNumberOfCases(int n) {
        int[] cent = { 25, 10, 5, 1 };
        int[][] memo = new int[cent.length][n + 1];
        return getNumberOfCasesHelper(memo, cent, 0, n);
    }

    static int getNumberOfCasesHelper(int[][] memo, int[] cent, int index, int amount) {
        if (index >= cent.length - 1)
            return 1;

        if (memo[index][amount] > 0)
            return memo[index][amount];

        int cases = 0;
        for (int i = 0; i * cent[index] <= amount; i++) {
            cases += getNumberOfCasesHelper(memo, cent, index + 1, amount - i * cent[index]);
        }
        memo[index][amount] = cases;
        return cases;
    }
}
