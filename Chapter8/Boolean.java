package Chapter8;

import java.util.*;

public class Boolean {
    public static void main(String[] args) {
        System.out.println(possible("1^0|0|1", false));
        System.out.println(possible("0&0&0&1^1|0", true));
    }

    static int possible(String s, boolean flag) {
        HashMap<String, Integer> hm = new HashMap<>();
        return search(s, flag, hm);
    }

    static int search(String s, boolean flag, HashMap<String, Integer> hm) {
        if (s.length() == 0)
            return 0;

        if (s.length() == 1) {
            if (convertToBool(s.charAt((0))) == flag)
                return 1;
            else
                return 0;
        }

        if (hm.containsKey(flag + s))
            return hm.get(flag + s);

        int sum = 0;
        for (int i = 1; i < s.length(); i = i + 2) {
            int leftFalse = search(s.substring(0, i), false, hm);
            int leftTrue = search(s.substring(0, i), true, hm);
            int rightFalse = search(s.substring(i + 1), false, hm);
            int rightTrue = search(s.substring(i + 1), true, hm);
            int total = leftFalse * rightFalse + leftFalse * rightTrue + leftTrue * rightFalse + leftTrue * rightTrue;

            int val = 0;
            if (s.charAt(i) == '&') {
                val = leftTrue * rightTrue;
            } else if (s.charAt(i) == '|') {
                val = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            } else if (s.charAt(i) == '^') {
                val = leftFalse * rightTrue + leftTrue * rightFalse;
            }
            sum += (flag ? val : total - val);
        }
        hm.put(flag + s, sum);
        return sum;
    }

    static boolean convertToBool(char c) {
        return c == '1';
    }
}
