package Chapter4;

import java.util.*;

import Chapter4.Graph.Node;

public class SearchRoute {
    public boolean searchRoute(Graph graph, Node start, Node end) {
        if (start == end)
            return true;

        Deque<Node> q = new ArrayDeque<Node>();
        for (Node n : graph.nodes) {
            n.state = false;
        }

        start.state = true;
        q.add(start);
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current == end) {
                return true;
            }

            for (Node n : current.adjacent) {
                if (!n.state) {
                    n.state = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
}
