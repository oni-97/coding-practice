package Chapter1;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 0, 7, 8, 9, 10 },
                { 11, 12, 0, 14, 15 },
                { 16, 0, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        if (zeroMatrix(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.printf("%2d ", matrix[i][j]);
                }
                System.out.println();
            }
        }
    }

    static boolean zeroMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; i++)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; j++)
                    matrix[i][j] = 0;
            }
        }

        if (isFirstRowZero) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }

        if (isFirstColZero) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
        return true;
    }

    // static boolean zeroMatrix(int[][] matrix) {
    // if (matrix.length == 0 || matrix[0].length == 0)
    // return false;
    // int n = matrix.length;
    // int m = matrix[0].length;

    // boolean[] isZeroRow = new boolean[n];
    // boolean[] isZeroCol = new boolean[m];
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < m; j++) {
    // if (matrix[i][j] == 0) {
    // isZeroRow[i] = true;
    // isZeroCol[j] = true;
    // }
    // }
    // }

    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < m; j++) {
    // if (isZeroRow[i] || isZeroCol[j]) {
    // matrix[i][j] = 0;
    // }
    // }
    // }
    // return true;
    // }
}
