package Chapter10;

import java.util.*;

public class SearchUnkownSize {
    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18 };
        MyList list = new MyList(array);
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 17));
    }

    static int search(MyList list, int target) {
        int high = 1;
        while (list.elementAt(high) != -1 && list.elementAt(high) < target) {
            high *= 2;
        }
        int low = high / 2;
        int mid, midVal;

        while (low <= high) {
            mid = (low + high) / 2;
            midVal = list.elementAt(mid);
            if (midVal == -1 || midVal > target) {
                high = mid - 1;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static class MyList {
        ArrayList<Integer> list;

        public MyList(int[] array) {
            list = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        }

        int elementAt(int i) {
            if (i >= list.size())
                return -1;
            else
                return list.get(i);
        }
    }
}
