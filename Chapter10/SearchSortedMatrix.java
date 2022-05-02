package Chapter10;

public class SearchSortedMatrix {
    boolean search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix[0].length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row--;
            }
        }

        for (int r = row; r < matrix.length; r++) {
            int low = 0;
            int high = col;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[r][mid] == target) {
                    return true;
                }
                if (matrix[r][mid] < target) {
                    low = mid + 1;
                } else if (matrix[r][mid] > target) {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
