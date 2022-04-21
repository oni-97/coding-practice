package Chapter4;

public class PartialTreeCheck {
    static boolean isPartialTree2(Node n1, Node n2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        createString(n1, s1);
        createString(n2, s2);
        return s1.indexOf(s2.toString()) != -1;
    }

    static void createString(Node n, StringBuilder s) {
        if (n == null) {
            s.append("X");
            return;
        }

        s.append(n.num + " ");
        createString(n.left, s);
        createString(n.right, s);
    }

    static boolean isPartialTree(Node n1, Node n2) {
        if (n2 == null)
            return true;
        else
            return recur(n1, n2);
    }

    static boolean recur(Node n1, Node n2) {
        if (n1 == null)
            return false;
        if (n1.num == n2.num) {
            if (isSameTree(n1, n2))
                return true;
        }
        return recur(n1.left, n2) || recur(n1.right, n2);
    }

    static boolean isSameTree(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;
        else if (n1 == null || n2 == null)
            return false;

        if (n1.num == n2.num) {
            return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
        } else
            return false;
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
