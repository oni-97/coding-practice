package Chapter2;

public class FindKthToEnd {
    public static void main(String[] args) {
        Node head = new Node(8);
        head.appendChild(7);
        head.appendChild(6);
        head.appendChild(5);
        head.appendChild(4);
        head.appendChild(3);
        head.appendChild(2);
        head.appendChild(1);

        Node n = findKthToEnd(head, 9);
        System.out.println(n == null ? "No" : n.data);
        n = findKthToEnd(head, 1);
        System.out.println(n == null ? "No" : n.data);
        n = findKthToEnd(head, 8);
        System.out.println(n == null ? "No" : n.data);
        n = findKthToEnd(head, 4);
        System.out.println(n == null ? "No" : n.data);
    }

    static Node findKthToEnd(Node head, int k) {
        if (head == null)
            return head;
        Node n = head;
        Node runner = head;
        int diff = 0;
        while (diff < k - 1 && runner != null) {
            runner = runner.next;
            diff++;
        }

        if (runner == null || diff < k - 1)
            return null;
        while (runner.next != null) {
            n = n.next;
            runner = runner.next;
        }
        return n;
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