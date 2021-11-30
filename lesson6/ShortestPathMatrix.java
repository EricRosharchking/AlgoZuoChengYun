package lesson6;

import java.util.Arrays;
import java.util.HashMap;

public class ShortestPathMatrix {
    
    public static void main(String[] args) {
        String str = "A,B;A,C;B,C;B,D;C,D;D,E;F,G;F,H;G,H";
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> nodeIndexMap = new HashMap<>();
        HashMap<Integer, String> indexNodeMap = new HashMap<>();
        int i = 0;
        String headNode = "A";
        for(String vertex: str.split(";")) {
            if (!nodeIndexMap.containsKey(vertex.split(",")[0])) {
                nodeIndexMap.put(vertex.split(",")[0], i);
                indexNodeMap.put(i++, vertex.split(",")[0]);
            }
            sb.append(nodeIndexMap.get(vertex.split(",")[0])+",");
            if (!nodeIndexMap.containsKey(vertex.split(",")[1])) {
                nodeIndexMap.put(vertex.split(",")[1], i);
                indexNodeMap.put(i++, vertex.split(",")[1]);
            }
            sb.append(nodeIndexMap.get(vertex.split(",")[1])+";");
        }
        Integer[][] graph = testMatrix(sb.toString());
        System.out.println("----------------------------");
        populateMatrixGraph(graph);
        for(Integer[] row: graph) {
            System.out.println(Arrays.toString(row));
        }

        i = nodeIndexMap.get(headNode);
        for (int j = 0; j < graph.length; j++) {
            if (indexNodeMap.get(j).equals(headNode)) {
                continue;
            }
            System.out.println(indexNodeMap.get(j) + " " + (graph[i][j] == null ? "INF" : graph[i][j]));
        }
    }

    public static Integer[][] testMatrix(String str) {
        String[] vertices = str.split(";");
        Integer[][] matrix = new Integer[vertices.length][3];
        for (int i = 0; i < vertices.length; i++) {
            matrix[i][0] = Integer.parseInt(vertices[i].split(",")[0]);
            matrix[i][1] = 1;
            matrix[i][2] = Integer.parseInt(vertices[i].split(",")[1]);
        }
        // Integer[][] matrix = { { 1, 1, 2 }, { 1, 1, 3 }, { 2, 1, 3 }, { 2, 1, 4 }, { 3, 1, 4 }, { 4, 1, 5 },
                // { 6, 1, 7 }, { 6, 1, 8 }, { 7, 1, 8 } };

        Integer[][] graph = GraphGenerator.createMatrix(matrix, 8);
        for (Integer[] row : graph)
            System.out.println(Arrays.toString(row));
        return graph;
    }

    public static void populateMatrixGraph(Integer[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = j; k < graph.length; k++) {
                    if (graph[i][j] != null && graph[j][k] != null) {
                        if (graph[i][k] == null || graph[i][k] > graph[i][j] + graph[j][k]) {
                            graph[i][k] = graph[i][j] + graph[j][k];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j< graph.length; j++) {
                if (graph[i][j] != null) {
                    graph[j][i] = graph[i][j];
                }
            }
        }
    }
}
