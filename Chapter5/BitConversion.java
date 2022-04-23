package Chapter5;
public class BitConversion {
    static int bitConversionRequired(int a, int b) {
        int x = a ^ b;
        int ans = 0;
        while (x != 0) {
            if ((x & 1) != 0)
                ans++;
            x >>>= 1;
        }
        return ans;
    }

    static int bitConversionRequiredEx(int a, int b) {
        int ans = 0;
        for (int x = a ^ b; x != 0; x &= (x - 1)) {
            ans++;
        }
        return ans;
    }
}
