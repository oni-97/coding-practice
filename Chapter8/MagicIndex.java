package Chapter8;

public class MagicIndex {
    int magicIndexEx(int[] array) {
        return search(array, 0, array.length - 1);
    }

    int search(int[] array, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (array[mid] == mid)
            return mid;

        int leftRes = search(array, start, Math.min(mid - 1, array[mid]));
        if (leftRes != -1)
            return leftRes;

        return search(array, Math.max(array[mid], mid + 1), end);
    }

    int magicIndex(int[] array) {
        if (array == null)
            return -1;
        int ok = -1;
        int ng = array.length;
        while (ng - ok != 1) {
            int mid = (ok + ng) / 2;
            if (array[mid] == mid)
                return mid;
            else if (array[mid] > mid)
                ng = mid;
            else
                ok = mid;
        }
        return -1;
    }
}
