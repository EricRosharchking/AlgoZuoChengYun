package lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EdgeSet {
    public HashMap<Node, List<Node>> hashMap;

    public EdgeSet(Graph graph) {
        for (Node node: graph.nodes.values()) {
            List<Node> set = new ArrayList<>();
            set.add(node);
            hashMap.put(node, set);
        }
    }

    public void union(Node from, Node to) {
        List<Node> fromSet = hashMap.get(from);
        List<Node> toSet = hashMap.get(to);
        for (Node fromNode: fromSet) {
            toSet.add(fromNode);
            hashMap.put(fromNode, toSet);
        }
    }

    public boolean isSameSet(Node from, Node to) {
        List<Node> fromSet = hashMap.get(from);
        List<Node> toSet = hashMap.get(to);
        return fromSet == toSet;
    }
}
