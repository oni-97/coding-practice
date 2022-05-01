package Chapter10;

public class Merge {
    void merge(int[] a, int[] b) {
        int current = a.length - 1;
        int aRight = a.length - 1 - b.length;
        int bRight = b.length - 1;
        while (aRight >= 0 && bRight >= 0) {
            if (a[aRight] >= b[bRight]) {
                a[current] = a[aRight];
                aRight--;
            } else {
                a[current] = b[bRight];
                bRight--;
            }
            current--;
        }

        while (bRight >= b.length - 1) {
            a[current] = b[bRight];
            bRight--;
        }

    }
}
