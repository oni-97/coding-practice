package Chapter4;

public class CheckBST {
    static boolean isBST(Node root) {
        return isBSTRecur(root, null, null);
    }

    static boolean isBSTRecur(Node node, Integer left, Integer right) {
        if (node == null)
            return true;

        if ((left != null && left >= node.num) || (right != null && node.num > right))
            return false;

        boolean resLeft = isBSTRecur(node.left, left, node.num);
        boolean resRight = isBSTRecur(node.right, node.num, right);
        return resLeft && resRight;
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
