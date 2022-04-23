package Chapter5;

public class Insert {
    public static void main(String[] args) {
        int N = 0b1010101010101;
        int M = 0b10011;
        int i = 2, j = 6;
        System.out.println(Integer.toBinaryString(insert(N, M, i, j)));
    }

    static int insert(int N, int M, int i, int j) {
        int mask = (M << i);
        int clear = ~(((1 << (j - i + 1)) - 1) << i);
        return (N & clear) | mask;
    }
}
