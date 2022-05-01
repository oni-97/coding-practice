package Chapter10;

public class SortAndSearch {
    int binarySearch(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < x) {
                low = mid + 1;
            } else if (array[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    int binarySearchRecursive(int[] array, int x, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (array[mid] < x)
            return binarySearchRecursive(array, x, mid + 1, high);
        else if (array[mid] > x)
            return binarySearchRecursive(array, x, low, mid - 1);
        else
            return mid;
    }

    void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }

    int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;

            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length);
    }

    void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
