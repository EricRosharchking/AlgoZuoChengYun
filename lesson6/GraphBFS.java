package lesson6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val);
            for (Node next: curr.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
