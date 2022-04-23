package Chapter5;

public class GeneralBitOperation {
    boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    int setBit(int num, int i) {
        return num | (1 << i);
    }

    int clearBit(int num, int i) {
        return num & (~(1 << i));
    }

    int clearBitsMSBthroughI(int num, int i) {
        return num & ((1 << i) - 1);
    }

    int clearBitsIthrough0(int num, int i) {
        return num & (-1 << (i + 1));
    }

    int updateBit(int num, int i, boolean bitIs1) {
        int val = bitIs1 ? 1 : 0;
        return (num & (~(1 << i))) | (val << i);
    }
}
