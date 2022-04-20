package Chapter4;

public class SameAncestor {

    static Node sameAncestor1(Node n1, Node n2) {
        int height1 = getHight(n1);
        int height2 = getHight(n2);
        int diff = Math.abs(height1 - height2);
        if (height1 > height2) {
            for (int i = 0; i < diff; i++) {
                n1 = n1.parent;
            }
        } else if (height1 < height2) {
            for (int i = 0; i < diff; i++) {
                n1 = n1.parent;
            }
        }

        while (n1 != null || n2 != null) {
            if (n1 == n2)
                return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return null;
    }

    static int getHight(Node n) {
        int height = 0;
        while (n != null) {
            n = n.parent;
            height++;
        }
        return height;
    }

    static Node sameAncestor2(Node root, Node n1, Node n2) {
        if (!covers(root, n1) || !covers(root, n2))
            return null;
        if (covers(n1, n2))
            return n1;
        if (covers(n2, n1))
            return n2;

        Node parent = n1.parent;
        Node sibling = getSibling(n1);
        while (!covers(sibling, n2)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    static Node sameAncestor3(Node root, Node n1, Node n2) {
        if (!covers(root, n1) || !covers(root, n2))
            return null;

        if (root == null || root == n1 || root == n2)
            return root;

        Node current = root;
        while (current != null) {
            if (covers(root.left, n1) && covers(root.left, n2)) {
                current = current.left;
            } else if (covers(root.right, n1) && covers(root.right, n2)) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    static boolean covers(Node root, Node n) {
        if (root == null)
            return false;
        if (root == n)
            return true;
        return covers(root.left, n) || covers(root.right, n);
    }

    static Node getSibling(Node n) {
        if (n == null || n.parent == null)
            return null;
        else
            return n.parent.left == n ? n.parent.right : n.parent.left;
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
