package Chapter4;

import java.util.*;

public class ArrayCreatingBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        Node n5 = new Node(5);
        root.left = n5;
        Node n17 = new Node(17);
        root.right = n17;

        Node n3 = new Node(3);
        n5.left = n3;
        Node n6 = new Node(6);
        n5.right = n6;

        Node n25 = new Node(25);
        n17.right = n25;

        Node n21 = new Node(21);
        n25.left = n21;
        List<List<Integer>> list = arrayCreatingBST(root);
        printList(list);
    }

    static void printList(List<List<Integer>> list) {
        for (List<Integer> subList : list) {
            System.out.println(subList.toString());
        }
    }

    static List<List<Integer>> arrayCreatingBST(Node n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n == null) {
            List<Integer> subList = new ArrayList<Integer>();
            list.add(subList);
            return list;
        }

        List<Integer> finish = new LinkedList<Integer>();
        finish.add(n.num);

        List<List<Integer>> leftLists = arrayCreatingBST(n.left);
        List<List<Integer>> rightLists = arrayCreatingBST(n.right);

        for (List<Integer> left : leftLists) {
            for (List<Integer> right : rightLists) {
                List<List<Integer>> weaved = new ArrayList<List<Integer>>();
                waveLists(left, right, weaved, finish);
                list.addAll(weaved);
            }
        }
        return list;
    }

    static void waveLists(List<Integer> left, List<Integer> right, List<List<Integer>> weaved,
            List<Integer> finish) {
        if (left.size() == 0 || right.size() == 0) {
            List<Integer> clone = new LinkedList<Integer>(finish);
            clone.addAll(left);
            clone.addAll(right);
            weaved.add(clone);
            return;
        }

        int leftTop = left.remove(0);
        finish.add(leftTop);
        waveLists(left, right, weaved, finish);

        left.add(0, leftTop);
        finish.remove(finish.size() - 1);

        int rightTop = right.remove(0);
        finish.add(rightTop);
        waveLists(left, right, weaved, finish);

        right.add(0, rightTop);
        finish.remove(finish.size() - 1);
    }

    static void createRecur(List<List<Integer>> list, List<Integer> subList, Queue<Node> q) {
        if (q.isEmpty()) {
            list.add(subList);
            return;
        }

        Node top = q.poll();
        subList.add(top.num);

        if (top.left == null && top.left == null) {
            createRecur(list, subList, q);
        } else if (top.left != null && top.right != null) {
            List<Integer> subList2 = new ArrayList<Integer>(subList);
            Queue<Node> q2 = new ArrayDeque<Node>(q);
            q.add(top.left);
            q.add(top.right);
            createRecur(list, subList, q);
            q2.add(top.right);
            q2.add(top.left);
            createRecur(list, subList2, q2);
        } else if (top.left != null || top.right != null) {
            Node n = top.left != null ? top.left : top.right;
            q.add(n);
            createRecur(list, subList, q);
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
