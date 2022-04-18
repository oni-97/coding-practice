package Chapter4;

import java.util.*;

public class SameDepthList {
    List<List<Node>> createSameDepthList(Node root) {
        if (root == null)
            return null;
        List<List<Node>> list = new ArrayList<List<Node>>();
        createRecur(root, list, 0);
        return list;
    }

    static void createRecur(Node n, List<List<Node>> list, int depth) {
        if (n == null)
            return;
        if (list.size() > depth) {
            list.get(depth).add(n);
        } else {
            List<Node> newList = new ArrayList<Node>();
            newList.add(n);
            list.add(newList);
        }
        createRecur(n.left, list, depth + 1);
        createRecur(n.right, list, depth + 1);
    }

    List<List<Node>> createSameDepthListWithBFS(Node root) {
        if (root == null)
            return null;
        List<List<Node>> list = new ArrayList<List<Node>>();
        List<Node> current = new ArrayList<Node>();
        current.add(root);
        while (current.size() > 0) {
            list.add(current);
            List<Node> parents = current;
            current = new ArrayList<Node>();
            for (Node parent : parents) {
                if (parent.left != null)
                    current.add(parent.left);
                if (parent.right != null)
                    current.add(parent.right);
            }
        }
        return list;
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
