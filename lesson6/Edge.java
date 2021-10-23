package lesson6;

public class Edge {
    public Integer weight;
    public Node from;
    public Node to;

    public Edge(Integer weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
