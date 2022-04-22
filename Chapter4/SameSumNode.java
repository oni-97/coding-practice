package Chapter4;

import java.util.*;

public class SameSumNode {
    static int countSameSumNode(Node root, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        return search(root, hm, 0, target);
    }

    static int search(Node n, HashMap<Integer, Integer> hm, int sum, int target) {
        if (n == null)
            return 0;

        sum += n.num;
        int val = sum - target;
        // int ans = 0;
        // if (hm.containsKey(val)) {
        // ans += hm.get(val);
        // }
        int ans = hm.getOrDefault(val, 0);
        if (sum == target)
            ans++;

        incrementMap(hm, sum);
        ans += search(n.left, hm, sum, target) + search(n.right, hm, sum, target);
        decrementMap(hm, sum);
        return ans;
    }

    static void incrementMap(HashMap<Integer, Integer> hm, int sum) {
        if (hm.containsKey(sum)) {
            hm.put(sum, hm.get(sum) + 1);
        } else {
            hm.put(sum, 1);
        }
    }

    static void decrementMap(HashMap<Integer, Integer> hm, int sum) {
        if (hm.containsKey(sum)) {
            hm.put(sum, hm.get(sum) - 1);
        }
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int d) {
            this.num = d;
        }
    }
}
