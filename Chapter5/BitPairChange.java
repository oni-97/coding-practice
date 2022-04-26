package Chapter5;

public class BitPairChange {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(bitPairChange(0b10011101)));
    }

    static int bitPairChange(int n) {
        int oddMask = 0xAAAAAAAA;
        int evenMask = 0x55555555;
        int odd = (n << 1) & oddMask;
        int even = (n >>> 1) & evenMask;
        return odd | even;
    }
}
