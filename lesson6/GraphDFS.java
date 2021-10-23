package lesson6;

import java.util.HashSet;
import java.util.Stack;

public class GraphDFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node next: curr.nexts) {
                if (!set.contains(next)) {
                    stack.push(curr);
                    stack.push(next); // 先压curr 再压next 保证栈中永远是dfs的顺序 然后一次弹出
                    set.add(next);
                    System.out.println(next.val); // 当next已在set中存在时 不操作
                    break; //break很重要，避免了无限循环
                }
            }
        }
    }
}
