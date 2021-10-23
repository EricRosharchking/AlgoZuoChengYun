package lesson6;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalMST {
    
    public static Set<Edge> kruskalMST(Graph graph) {
        if (graph == null || graph.edges.isEmpty()) {
            return null;
        }
        Set<Edge> res = new HashSet<>();
        EdgeSet edgeSet = new EdgeSet(graph);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge: graph.edges) {
            priorityQueue.add(edge);
        }
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!edgeSet.isSameSet(edge.from, edge.to)) {
                res.add(edge);
                edgeSet.union(edge.from, edge.to);
            }
        }
        return res;
    }
}
