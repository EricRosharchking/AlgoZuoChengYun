package lesson6;

public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix) { // N 个数组 [from, weight, to] 来表示所有的边
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i ++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][2];
            Integer weight = matrix[i][1];
            if (!graph.nodes.keySet().contains(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.keySet().contains(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.edges.add(newEdge);
            fromNode.nexts.add(toNode);
            fromNode.out ++;
            toNode.in ++;
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
