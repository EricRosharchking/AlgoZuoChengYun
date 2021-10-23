package lesson6;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public HashMap<Integer, Node> nodes;
    public ArrayList<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }
}
