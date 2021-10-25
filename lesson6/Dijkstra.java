package lesson6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Dijkstra {
    
    public static void main(String[] args) {
        Integer[][] matrix = {
            {1,1,2},
            {1,1,3},
            {2,1,3},
            {2,1,4},
            {4,1,5},
            {6,1,7},
            {6,1,8},
            {8,1,9}
        };
        Dijkstra d = new Dijkstra();
        Graph g = GraphGenerator.createGraph(matrix);
        HashMap<Node, Integer> map = d.getDistance(g.nodes.get(1));
        for (Node n: g.nodes.values()) {
            if (n.val != 1) {
                System.out.println(n.val + " " + map.get(n));
            }
        }
    }

    public HashMap<Node, Integer> getDistance(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head,0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinNode(distanceMap, selectedNodes);
        while(minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge: minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + 1);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + 1));
            }
            selectedNodes.add(minNode);
            minNode = getMinNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private Node getMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Entry<Node, Integer> entry: distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
