package basics;

import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        // ex 1
        List<List<Integer>> adj = List.of(
            List.of(1, 2),
            List.of(0, 2),
            List.of(0, 1, 3),
            List.of(2)
        );
        int v = 4;
        int provinces = numberOfProvinces(adj, v);
        System.out.println("Number of provinces: " + provinces);

        // ex 2 of having a disconnected graph
        List<List<Integer>> adj2 = List.of(
            List.of(1),
            List.of(0, 2),
            List.of(1, 3),
            List.of(2),
            List.of(5),
            List.of(4)
        );
        int v2 = 6;
        int provinces2 = numberOfProvinces(adj2, v2);
        System.out.println("Number of provinces in disconnected graph: " + provinces2);
    }

    /**
     * Count the number of provinces in a graph represented by an adjacency list.
     * @param adj Adjacency list representing the graph.
     * @param v Number of vertices in the graph.
     * @return The number of provinces (connected components) in the graph.
     * Approach:
     * 1. Initialize a boolean array to keep track of visited nodes.
     * 2. Iterate through each node in the graph.
     * 3. If a node is not visited, increment the province count and perform a
     *   depth-first search (DFS) from that node to mark all reachable nodes as visited.
     * 4. Return the count of provinces.
     */
    public static int numberOfProvinces(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adj);
            }
        }
        return count;
    }

    /**
     * Perform a depth-first search (DFS) on the graph to mark all reachable nodes from the given node.
     * @param node The current node to start the DFS from.
     * @param visited Array to keep track of visited nodes.
     * @param adj Adjacency list representing the graph.
     * Approach:
     *            1. Mark the current node as visited.
     *            2. Iterate through all neighbours of the current node.
     *            3. If a neighbour is not visited, recursively call DFS on that neighbour.
     *            4. This will ensure that all nodes in the same connected component are marked as visited.
     *            5. The DFS will continue until all reachable nodes from the starting node are visited.
     */
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }
        }
    }
}
