package Chapter10;
public class SearchRoated {
    public static void main(String[] args) {
        int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
        System.out.println(search(array, 15));
        System.out.println(search(array, 16));
        System.out.println(search(array, 19));
        System.out.println(search(array, 20));
        System.out.println(search(array, 25));
        System.out.println(search(array, 1));
        System.out.println(search(array, 3));
        System.out.println(search(array, 4));
        System.out.println(search(array, 5));
        System.out.println(search(array, 7));
        System.out.println(search(array, 10));
        System.out.println(search(array, 14));
        System.out.println();

        int[] array2 = { 2, 2, 2, 3, 4, 2 };
        System.out.println(search(array2, 2));
        System.out.println(search(array2, 3));
        System.out.println(search(array2, 4));
        System.out.println();

        int[] a = { 2, 3, 1, 2, 2, 2, 2, 2, 2, 2 };
        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
    }

    static int search(int[] array, int target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    static int binarySearch(int[] array, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (array[mid] == target)
            return mid;

        if (array[left] < array[mid]) {
            if (array[left] <= target && target < array[mid]) {
                return binarySearch(array, left, mid - 1, target);
            } else {
                return binarySearch(array, mid + 1, right, target);

            }
        } else if (array[left] > array[mid]) {
            if (array[mid] < target && target <= array[right]) {
                return binarySearch(array, mid + 1, right, target);
            } else {
                return binarySearch(array, left, mid - 1, target);

            }
        } else {
            int res = binarySearch(array, mid + 1, right, target);
            if (array[mid] == array[right]) {
                if (res == -1) {
                    res = binarySearch(array, left, mid - 1, target);
                }
            }
            return res;
        }
    }
}
