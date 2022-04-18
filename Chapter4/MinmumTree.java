package Chapter4;

public class MinmumTree {
    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Node root = createMinTree(array);
        printNode(root, 0);
    }

    static void printNode(Node n, int depth) {
        if (n == null) {
            System.out.println(depth + " : null");
            return;
        }

        System.out.println(depth + " : " + n.num);
        printNode(n.left, depth + 1);
        printNode(n.right, depth + 1);
    }

    static Node createMinTree(int[] array) {
        if (array == null || array.length == 0)
            return null;
        return createRecur(0, array.length - 1, array);
    }

    static Node createRecur(int left, int right, int[] array) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        Node leftNode = createRecur(left, mid - 1, array);
        Node rightNode = createRecur(mid + 1, right, array);
        Node midNode = new Node(array[mid]);
        midNode.left = leftNode;
        midNode.right = rightNode;
        return midNode;
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
