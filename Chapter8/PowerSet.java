package Chapter8;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        ArrayList<ArrayList<Integer>> powerSet = getPowerSet(set);
        for (ArrayList<Integer> list : powerSet) {
            System.out.println(list.toString());
        }
    }

    static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set) {
        if (set == null)
            return null;

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        createPowerSet(powerSet, set, set.size(), 0, new ArrayList<Integer>());
        return powerSet;
    }

    static void createPowerSet(ArrayList<ArrayList<Integer>> powerSet, ArrayList<Integer> set, int size, int index,
            ArrayList<Integer> current) {
        if (size == index) {
            powerSet.add(current);
            return;
        }
        ArrayList<Integer> clone = new ArrayList<Integer>(current);
        current.add(set.get(index));
        createPowerSet(powerSet, set, size, index + 1, current);
        createPowerSet(powerSet, set, size, index + 1, clone);
    }
}
