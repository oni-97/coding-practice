package Chapter10;

public class DuplicatedNumber {

    void duplicatedNumber(int[] array) {
        BitSet bs = new BitSet(array.length);
        for (int i = 0; i < array.length; i++) {
            if (bs.isUsed(array[i] - 1)) {
                System.out.println(array[i]);
            } else {
                bs.add(array[i] - 1);
            }
        }
    }

    class BitSet {
        int[] used;

        public BitSet(int n) {
            used = new int[n / 32 + 1];
        }

        public void add(int n) {
            used[n / 32] |= 1 << (n % 32);
        }

        public boolean isUsed(int n) {
            return (used[n / 32] & (1 << (n % 32))) == 0;
        }
    }
}
