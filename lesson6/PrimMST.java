package lesson6;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST {
    
    public Set<Edge> primMST(Graph graph) {
        if (graph == null || graph.edges.isEmpty()) {
            return null;
        }
        Set<Node> set = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Node node: graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge: node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        res.add(edge);
                        for (Edge nextEdge: toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return res;
    }
}
