package Chapter4;

public class NextNode {
    static Node nextNode(Node n) {
        if (n == null)
            return null;
        if (n.right == null) {
            return dfsParent(n);
        }
        return dfsNext(n.right);
    }

    static Node dfsNext(Node n) {
        if (n == null)
            return null;
        if (n.left == null)
            return n;
        return dfsNext(n.left);
    }

    static Node dfsParent(Node n) {
        if (n.parent == null) {
            return null;
        }

        if (n.parent.right == n) {
            return dfsParent(n.parent);
        }
        return n.parent;
    }

    static class Node {
        int num;
        Node left;
        Node right;
        Node parent;

        public Node(int d) {
            this.num = d;
        }
    }
}
