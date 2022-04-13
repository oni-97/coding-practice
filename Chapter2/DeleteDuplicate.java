package Chapter2;

import java.util.*;

public class DeleteDuplicate {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendChild(1);
        head.appendChild(1);
        head.appendChild(2);
        head.appendChild(1);
        head.appendChild(1);
        head.appendChild(3);
        head.appendChild(4);
        head.appendChild(1);

        Node n = deleteDuplicateWithoutUsingMemory(head);
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    static Node deleteDuplicateWithoutUsingMemory(Node head) {
        if (head == null)
            return head;

        Node n = head;
        while (n != null) {
            Node runner = n;
            while (runner.next != null) {
                if (n.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
        return head;
    }

    static Node deleteDuplicateUsingMemory(Node head) {
        HashSet<Integer> hs = new HashSet<Integer>();
        if (head == null)
            return head;

        Node n = head;
        hs.add(head.data);
        while (n.next != null) {
            if (!hs.contains(n.next.data)) {
                hs.add(n.next.data);
                n = n.next;
                continue;
            }

            n.next = n.next.next;
        }
        return head;
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