package Chapter8;

import java.util.*;

public class EightQueen {
    static void solveEightQueen(int row, Integer[] columns, ArrayList<Integer[]> list) {
        if (row == 8) {
            Integer[] addList = columns.clone();
            list.add(addList);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (checkCol(i, columns, row) && checkDia(i, columns, row)) {
                columns[row] = i;
                solveEightQueen(row + 1, columns, list);
            }
        }
    }

    static boolean checkCol(int col, Integer[] columns, int row) {
        for (int i = 0; i < row; i++) {
            if (columns[i] == col)
                return false;
        }
        return true;
    }

    static boolean checkDia(int col, Integer[] columns, int row) {
        for (int i = 0; i < row; i++) {
            if (Math.abs(col - columns[i]) == (row - i))
                return false;
        }
        return true;
    }
}
