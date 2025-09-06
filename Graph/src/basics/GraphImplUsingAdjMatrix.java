package basics;

public class GraphImplUsingAdjMatrix {
    private int[][] adjMatrix;
    private int numOfVertices;

    public GraphImplUsingAdjMatrix(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjMatrix = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int i, int j) {
        // marking i & j as 1
        adjMatrix[i][j] = 1;

        // marking j & i as 1
        adjMatrix[j][i] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphImplUsingAdjMatrix g = new GraphImplUsingAdjMatrix(5);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.printGraph();
    }
}
