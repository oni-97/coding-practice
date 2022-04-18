package Chapter4;

public class BalancedCheck {
    static boolean isBalanced(Node root) {
        Info result = isBalancedRecur(root, 0);
        return result.flag;
    }

    static Info isBalancedRecur(Node n, int depth) {
        if (n == null)
            return new Info(true, depth);
        Info resLeft = isBalancedRecur(n.left, depth + 1);
        Info resRight = isBalancedRecur(n.right, depth + 1);
        if (!resLeft.flag)
            return resLeft;
        if (!resRight.flag)
            return resRight;
        if (Math.abs(resLeft.depth - resRight.depth) > 1)
            return new Info(false, depth);
        else {
            return new Info(true, Math.max(resLeft.depth, resRight.depth));
        }
    }

    static class Info {
        boolean flag;
        int depth;

        public Info(boolean flag, int depth) {
            this.flag = flag;
            this.depth = depth;
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
