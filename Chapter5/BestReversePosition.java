package Chapter5;

import java.util.*;

public class BestReversePosition {
    public static void main(String[] args) {
        System.out.println(bestReverse(-1));
        System.out.println(bestReverse(0b11011101110011111));
        System.out.println(bestReverse(0b11111111011101110011111));
        System.out.println(bestReverse(0));

        System.out.println(bestReverseOpt(-1));
        System.out.println(bestReverseOpt(0b11011101110011111));
        System.out.println(bestReverseOpt(0b11111111011101110011111));
        System.out.println(bestReverseOpt(0));
    }

    static int bestReverseOpt(int num) {
        if (num == -1)
            return Integer.SIZE;

        int max = 0;
        int pre = 0;
        int current = 0;
        while (num != 0) {
            if ((num & 1) != 0) {
                current++;
            } else {
                pre = (num & 2) != 0 ? current : 0;
                current = 0;
            }
            max = Math.max(max, current + pre + 1);
            num >>>= 1;
        }
        max = Math.max(max, current);
        return max;
    }

    static int bestReverse(int num) {
        int oneCnt = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        while (num != 0) {
            if ((num & 1) > 0) {
                oneCnt++;
            } else if (oneCnt > 0) {
                list.add(oneCnt);
                oneCnt = 0;
            } else {
                list.add(0);
            }
            num >>>= 1;
        }
        if (oneCnt > 0)
            list.add(oneCnt);
        list.add(-1);

        int max = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            int current = list.get(i) + list.get(i + 1) + 1;
            if (current > max)
                max = current;
        }
        return max;
    }

}
