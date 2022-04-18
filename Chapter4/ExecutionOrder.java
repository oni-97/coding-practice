package Chapter4;

import java.util.*;

public class ExecutionOrder {
    public static void main(String[] args) {
        String[] projects = { "a", "b", "c", "d", "e", "f" };
        String[][] dependency = {
                { "d", "a" },
                { "b", "f" },
                { "d", "b" },
                { "a", "f" },
                { "c", "d" }
        };

        List<String> list = getExecutableOrder(projects, dependency);
        for (String s : list) {
            System.out.print(s + ">");
        }
        System.out.println();

        String[] projects2 = { "a", "b", "c", "d" };
        String[][] dependency2 = {
                { "b", "a" },
                { "b", "c" },
                { "c", "d" },
                { "d", "b" }
        };
        if (getExecutableOrder(projects2, dependency2) == null) {
            System.out.println("Null");
        }
    }

    static List<String> getExecutableOrder(String[] projects, String[][] dependency) {
        HashMap<String, Integer> hsIn = new HashMap<String, Integer>();
        HashMap<String, List<String>> hsNext = new HashMap<String, List<String>>();
        HashMap<String, Boolean> isOk = new HashMap<String, Boolean>();

        for (String s : projects) {
            hsIn.put(s, 0);
            hsNext.put(s, new ArrayList<String>());
            isOk.put(s, false);
        }

        for (String[] d : dependency) {
            String first = d[0];
            String second = d[1];
            List<String> list = hsNext.get(second);
            list.add(first);
            hsIn.put(first, hsIn.get(first) + 1);
        }

        int cnt = 0;
        List<String> ans = new ArrayList<String>();
        while (cnt < projects.length) {
            boolean flag = false;
            for (Map.Entry<String, Integer> entry : hsIn.entrySet()) {
                if (!isOk.get(entry.getKey()) && entry.getValue() == 0) {
                    ans.add(entry.getKey());
                    for (String next : hsNext.get(entry.getKey())) {
                        hsIn.put(next, hsIn.get(next) - 1);
                    }
                    isOk.put(entry.getKey(), true);
                    cnt++;
                    flag = true;
                }
            }
            if (!flag)
                return null;
        }

        return ans;
    }

}
