package Chapter2;

public class DeleteNodeBetween {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendChild(2);
        head.appendChild(3);
        head.appendChild(4);
        head.appendChild(5);
        head.appendChild(6);
        head.appendChild(7);

        if (deleteNodeBetween(getNode(head, 3)))
            printNode(head);
    }

    static Node getNode(Node head, int n) {
        Node node = head;
        for (int i = 0; i < n - 1; i++) {
            node = node.next;
        }
        return node;
    }

    static void printNode(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + ">");
            n = n.next;
        }
    }

    static boolean deleteNodeBetween(Node node) {
        if (node == null || node.next == null)
            return false;

        node.data = node.next.data;
        node.next = node.next.next;
        return true;
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