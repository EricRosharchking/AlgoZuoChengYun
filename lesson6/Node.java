package lesson6;

import java.util.ArrayList;

public class Node {
    public Integer val;
    public Integer in;
    public Integer out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(Integer val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
