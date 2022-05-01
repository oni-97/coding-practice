package Chapter10;

public class SearchGapArray {
    public static void main(String[] args) {
        String[] list = { "aaa", "", "", "bbb", "", "", "", "ccc", "ddddd", "", "", "ee", "", "f" };
        for (String s : list) {
            if (!s.isEmpty()) {
                System.out.println(search(list, s));
            }
        }
        System.out.println(search(list, "b"));
    }

    static int search(String[] strs, String target) {
        return binarySearch(strs, 0, strs.length - 1, target);
    }

    static int binarySearch(String[] strs, int low, int high, String target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        String str = strs[mid];
        if (str.isEmpty()) {
            int res = binarySearch(strs, low, mid - 1, target);
            if (res == -1) {
                res = binarySearch(strs, mid + 1, high, target);
            }
            return res;
        } else if (str.compareTo(target) < 0) {
            return binarySearch(strs, mid + 1, high, target);
        } else if (str.compareTo(target) > 0) {
            return binarySearch(strs, low, mid - 1, target);
        } else {
            return mid;
        }
    }
}
