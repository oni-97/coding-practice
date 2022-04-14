package Chapter2;

import java.util.*;

public class PalindromeList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendChild(2);
        head.appendChild(3);
        head.appendChild(3);
        head.appendChild(2);
        head.appendChild(1);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeWithStack(head));
        System.out.println(isPalindromeWithRecur(head, 6).result);

        head = new Node(1);
        head.appendChild(2);
        head.appendChild(3);
        head.appendChild(4);
        head.appendChild(1);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeWithStack(head));
        System.out.println(isPalindromeWithRecur(head, 5).result);

    }

    static Result isPalindromeWithRecur(Node node, int length) {
        if (node == null || length <= 0) {
            return new Result(node, true);
        } else if (length == 1) {
            return new Result(node.next, true);
        }

        Result res = isPalindromeWithRecur(node.next, length - 2);
        if (res.node == null || !res.result)
            return res;

        res.result = (node.data == res.node.data);
        res.node = res.node.next;
        return res;
    }

    static class Result {
        Node node;
        boolean result;

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    static boolean isPalindromeWithStack(Node head) {
        Node fast = head;
        Node slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        while (slow != null) {
            if (stack.empty())
                return false;
            int data = stack.pop();
            if (slow.data != data)
                return false;
            slow = slow.next;
        }
        return true;
    }

    static boolean isPalindrome(Node head) {
        if (head == null)
            return false;
        Node n1 = head;
        Node n2 = getReverseList(head);
        while (n1 != null) {
            if (n1.data != n2.data)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    static Node getReverseList(Node head) {
        Node reverseList = null;
        Node n = head;
        while (n != null) {
            reverseList = insertBefore(reverseList, n.data);
            n = n.next;
        }
        return reverseList;
    }

    static Node insertBefore(Node n, int d) {
        Node node = new Node(d);
        node.next = n;
        return node;
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
