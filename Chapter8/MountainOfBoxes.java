package Chapter8;

import java.util.*;

public class MountainOfBoxes {
    int pileHeight(ArrayList<Box> boxes) {
        Collections.sort(
                boxes,
                new Comparator<Box>() {
                    @Override
                    public int compare(Box obj1, Box obj2) {
                        return obj2.h - obj1.h;
                    }
                });

        int[] memo = new int[boxes.size()];
        int max = 0;
        for (int i = 0; i < boxes.size(); i++) {
            max = Math.max(max, heightHelper(boxes, i, memo));
        }

        return max;
    }

    static int heightHelper(ArrayList<Box> boxes, int pre, int[] memo) {
        if (memo[pre] > 0)
            return memo[pre];

        int max = 0;
        for (int i = pre + 1; i < boxes.size(); i++) {
            if (boxes.get(i).isPileOn(boxes.get(pre))) {
                int sum = heightHelper(boxes, i, memo);
                max = Math.max(max, sum);
            }
        }
        memo[pre] = max + boxes.get(pre).h;
        return max;
    }

    static class Box {
        int w;
        int h;
        int d;

        public boolean isPileOn(Box b) {
            if (this.w < b.w && this.h < b.h && this.d < b.d)
                return true;
            else
                return false;
        }

        public int min() {
            return Math.min(Math.min(w, h), d);
        }

        public int max() {
            return Math.max(Math.max(w, h), d);
        }
    }
}
