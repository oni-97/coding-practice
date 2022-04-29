package Chapter8;

import java.util.*;

public class Robot {
    static List<Point> root(boolean[][] cell) {
        if (cell == null || cell.length == 0)
            return null;
        List<Point> list = new ArrayList<>();
        HashSet<Point> failPoints = new HashSet<>();
        if (search(cell.length - 1, cell[0].length - 1, cell, list, failPoints)) {
            return list;
        } else {
            return null;
        }
    }

    static boolean search(int r, int c, boolean[][] cell, List<Point> list, HashSet<Point> failPoints) {
        if (r < 0 || c < 0)
            return false;
        if (r == 0 && c == 0) {
            list.add(new Point(r, c));
            return true;
        }

        if (failPoints.contains(new Point(r, c)))
            return false;

        if (cell[r][c]) {
            if (search(r - 1, c, cell, list, failPoints) || search(r, c - 1, cell, list, failPoints)) {
                list.add(new Point(r, c));
                return true;
            } else {
                return false;
            }
        } else {
            failPoints.add(new Point(r, c));
            return false;
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
