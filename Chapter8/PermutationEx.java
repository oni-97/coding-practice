package Chapter8;

import java.util.*;

public class PermutationEx {
    public static void main(String[] args) {
        ArrayList<String> list = permutation("112223");
        for (String s : list) {
            System.out.println(s);
        }

        list = permutation("");
        for (String s : list) {
            System.out.println(s);
        }

        list = permutation("aaaaaaaaaaaaaaaaaaaaaaaaa");
        for (String s : list) {
            System.out.println(s);
        }
    }

    static ArrayList<String> permutation(String s) {
        if (s == null)
            return null;
        ArrayList<String> list = new ArrayList<>();
        create(list, s, "", s.length());
        return list;
    }

    static void create(ArrayList<String> list, String s, String current, int length) {
        if (current.length() == length) {
            list.add(current);
            return;
        }

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
                String newString = current + s.charAt(i);
                create(list, s.substring(0, i) + s.substring(i + 1), newString, length);
            }
        }
    }
}
