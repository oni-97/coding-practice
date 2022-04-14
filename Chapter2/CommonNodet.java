package Chapter2;

public class CommonNodet {
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.appendChild(4);
        head1.appendChild(9);

        Node head2 = new Node(1);
        head2.next = head1;
        head2 = insertBefore(head2, 1);
        head2 = insertBefore(head2, 9);
        
        head1 = insertBefore(head1, 1);
        head1 = insertBefore(head1, 1);

        printNode(commonNode(head1, head2));
    }

    static Node insertBefore(Node n, int d) {
        Node node = new Node(d);
        node.next = n;
        return node;
    }

    static void printNode(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + ">");
            n = n.next;
        }
    }

    static Node commonNode(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1 < len2)
            head1 = fillZero(head1, len2 - len1);
        else if (len2 > len1)
            head2 = fillZero(head2, len1 - len2);

        Node n1 = head1, n2 = head2;
        while (n1 != null && n2 != null) {
            if (n1 == n2)
                return n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    static Node fillZero(Node head, int diff) {
        Node node = head;
        for (int i = 0; i < diff; i++) {
            Node newNode = new Node(0);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    static int getLength(Node n) {
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
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
