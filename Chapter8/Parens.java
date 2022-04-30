package Chapter8;

import java.util.*;

public class Parens {
    public static void main(String[] args) {
        ArrayList<String> list = getParens(0);
        for (String s : list) {
            System.out.println(s);
        }

        list = getParens(1);
        for (String s : list) {
            System.out.println(s);
        }

        list = getParens(4);
        for (String s : list) {
            System.out.println(s);
        }
    }

    static ArrayList<String> getParens(int n) {
        ArrayList<String> list = new ArrayList<String>();
        if (n <= 0)
            return list;
        create(list, n, n, "");
        return list;
    }

    static void create(ArrayList<String> list, int left, int right, String s) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > 0) {
            create(list, left - 1, right, s + "(");
        }
        if (right > 0 && left < right) {
            create(list, left, right - 1, s + ")");
        }
    }
}
