package Chapter2;

import java.util.*;

public class DetectLoop {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        n5.next = n3;

        System.out.println(detectLoop(n1).data);
        n5.next = null;
        System.out.println(detectLoop(n1));
    }

    static Node detectLoop(Node head) {
        Node faster = head;
        Node slower = head;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster)
                break;
        }

        if (faster == null || faster.next == null)
            return null;
        slower = head;
        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }
        return slower;
    }

    static Node detectLoopWithHash(Node head1) {
        HashSet<Node> hs = new HashSet<Node>();
        Node node = head1;
        while (node != null) {
            if (hs.contains(node))
                return node;

            hs.add(node);
            node = node.next;
        }
        return null;
    }

    static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            this.data = d;
        }

        void appendChild(int d) {
            Node end = new Node(d);
            Node node = this;
            while (node.next != null)
                node = node.next;
            node.next = end;
        }
    }
}
