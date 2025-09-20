package striver;

public class Edge {

    public int source;
    public int destination;
    // Optional weight for the edge, can be used in weighted graphs
    public int weight;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

}
