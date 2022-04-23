package Chapter5;

public class NextAndPreNumber {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(getNext(0xFF00)));
        System.out.println(Integer.toBinaryString(getNext(0b11000101)));
        System.out.println(Integer.toBinaryString(getNext(0b11001110000)));
    }

    static int getNext(int num) {
        int oneCnt = 0;
        boolean isFind = false;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((num & (1 << i)) > 0) {
                oneCnt++;
            } else if (oneCnt > 0) {
                num |= (1 << i);
                num &= ~((1 << i) - 1);
                num |= (1 << (oneCnt - 1)) - 1;
                isFind = true;
                break;
            }
        }

        if (isFind) {
            return num;
        } else {
            return -1;
        }
    }

    static int getPre(int num) {
        int zeroCnt = 0;
        boolean isFind = false;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((num & (1 << i)) == 0) {
                zeroCnt++;
            } else if (zeroCnt > 0) {
                num &= ~(1 << i);
                num |= (1 << i) - 1;
                num &= ~((1 << (zeroCnt - 1)) - 1);
                isFind = true;
                break;
            }
        }

        if (isFind) {
            return num;
        } else {
            return -1;
        }
    }
}
