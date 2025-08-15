package basics;

import java.util.ArrayList;

public class GraphImpl {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.destination + ", ");
            }
            System.out.println();
        }

        createGraphWithWeights(graph);
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.destination + ", " + edge.weight + "), ");
            }
            System.out.println();
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 2));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
    }

    public static void createGraphWithWeights(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 10));
        graph[0].add(new Edge(0, 4, 5));

        graph[2].add(new Edge(2, 0, 10));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 4));

        graph[1].add(new Edge(1, 3, 2));
        graph[1].add(new Edge(1, 2, 1));

        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 1, 2));

        graph[4].add(new Edge(4, 0, 5));
    }
}
