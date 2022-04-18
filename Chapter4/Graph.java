package Chapter4;

import java.util.*;

public class Graph {
    List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }

    static class Node {
        String name;
        List<Node> adjacent;
        boolean state;

        public Node(String name) {
            this.name = name;
            adjacent = new ArrayList<Node>();
            state = false;
        }

        public void add(Node n) {
            adjacent.add(n);
        }
    }
}
