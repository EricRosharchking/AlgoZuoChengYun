package lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {
    
    public static ArrayList<Node> sort(Graph graph) {
        if (graph == null || graph.nodes.isEmpty()) {
            return null;
        }
        ArrayList<Node> res = new ArrayList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node: graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.nexts.isEmpty()) {
                zeroInQueue.add(node);
            }
        }

        while (!zeroInQueue.isEmpty()) {
            Node curr = zeroInQueue.poll();
            res.add(curr);
            for (Node next: curr.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }
}
