package Chapter2;

public class SplitList {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendChild(5);
        head.appendChild(8);
        head.appendChild(5);
        head.appendChild(10);
        head.appendChild(2);
        head.appendChild(1);

        printNode(splitList(head, 5));
    }

    static Node splitList(Node head, int pivot) {
        Node n = head;
        Node runner = head;
        Node pre = runner;
        while (runner != null) {
            if (runner.data < pivot) {
                Node newHead = new Node(runner.data);
                newHead.next = n;
                n = newHead;
                if (runner.next != null) {
                    runner.data = runner.next.data;
                    runner.next = runner.next.next;
                } else {
                    pre.next = null;
                    runner = null;
                }
            } else {
                pre = runner;
                runner = runner.next;
            }
        }
        return n;
    }

    static void printNode(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + ">");
            n = n.next;
        }
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
