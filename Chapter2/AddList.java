package Chapter2;

public class AddList {
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.appendChild(4);
        head1.appendChild(9);
        Node head2 = new Node(9);
        head2.appendChild(5);
        head2.appendChild(5);
        head2.appendChild(1);

        printNode(addList(head1, head2));
    }

    static Node addList(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1 < len2)
            head1 = fillZero(head1, len2 - len1);
        else if (len1 > len2)
            head1 = fillZero(head2, len1 - len2);

        CarryInfo result = addListHelper(head1, head2);
        if (result.carry == 0)
            return result.node;

        Node head = new Node(result.carry);
        head.next = result.node;
        return head;
    }

    static CarryInfo addListHelper(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return new CarryInfo(0, null);
        CarryInfo result = addListHelper(n1.next, n2.next);
        int val = n1.data + n2.data + result.carry;
        Node node = new Node(val % 10);
        node.next = result.node;
        return new CarryInfo(val / 10, node);
    }

    static class CarryInfo {
        int carry;
        Node node;

        public CarryInfo(int carry, Node node) {
            this.carry = carry;
            this.node = node;
        }
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

    static Node addListSub(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int val = carry;
        if (n1 != null)
            val += n1.data;
        if (n2 != null)
            val += n2.data;
        Node node = new Node(val % 10);
        node.next = addListSub(
                n1 == null ? null : n1.next,
                n2 == null ? null : n2.next,
                val / 10);
        return node;
    }

    // static Node addList(Node n1, Node n2) {
    // int num1 = convertListToNum(n1);
    // int num2 = convertListToNum(n2);
    // int sum = num1 + num2;
    // return convertNumToList(sum);
    // }

    // static Node convertNumToList(int n) {
    // Node head = null;
    // Node node = head;
    // while (n != 0) {
    // Node newNode = new Node(n % 10);
    // n /= 10;
    // if (head == null) {
    // head = newNode;
    // } else {
    // node.next = newNode;
    // }
    // node = newNode;
    // }
    // return head;
    // }

    // static int convertListToNum(Node n) {
    // int res = 0;
    // int digit = 1;
    // while (n != null) {
    // res += n.data * digit;
    // digit *= 10;
    // n = n.next;
    // }
    // return res;
    // }

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
