package Chapter8;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> list = permutation("123");
        for (String s : list) {
            System.out.println(s);
        }

        list = permutation("");
        for (String s : list) {
            System.out.println(s);
        }
    }

    static ArrayList<String> permutation(String s) {
        if (s == null)
            return null;
        ArrayList<String> list = new ArrayList<>();
        create(list, s, "", 0);
        return list;
    }

    static void create(ArrayList<String> list, String s, String current, int index) {
        if (index == s.length()) {
            list.add(current);
            return;
        }

        for (int i = 0; i <= current.length(); i++) {
            String newString = current.substring(0, i) + s.charAt(index) + current.substring(i);
            create(list, s, newString, index + 1);
        }
    }
}
