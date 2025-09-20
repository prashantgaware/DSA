package basics;

import java.util.List;

public class CycleDetectionInUndirectedGraphUsingDFS {

    /**
     * Function to detect cycle in an undirected graph using DFS
     * @param v number of vertices
     * @param adj adjacency list
     * @return true if cycle is detected, false otherwise
     * Approach:
     * 1. Create a boolean array to keep track of visited nodes.
     * 2. Iterate through all nodes. If a node is not visited, perform a
     *   DFS from that node.
     *   3. In the DFS, for each neighbor of the current node:
     *      a. If the neighbor is not visited, recursively perform DFS on it.
     *      b. If the neighbor is visited and is not the parent of the current node,
     *         a cycle is detected; return true.
     * 4. If the DFS completes without finding a cycle, return false.
     * 5. If all nodes are processed without finding a cycle, return false.
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the visited array and recursion stack.
     * Dry Run:
     * Consider a graph with 5 vertices and edges: (0-1), (1-2), (2-0), (1-3), (3-4)
     * Starting DFS from node 0:
     * - visited = [true, false, false, false, false]
     * - From 0, visit neighbor 1:
     *   - visited = [true, true, false, false, false]
     *   - From 1, visit neighbor 0 (parent, ignore), then visit neighbor 2:
     *     - visited = [true, true, true, false, false]
     *     - From 2, visit neighbor 1 (parent, ignore), then visit neighbor 0:
     *       - 0 is visited and not the parent of 2, cycle detected, return true.
     * The function returns true indicating a cycle is present in the graph.
     */
    public static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Depth First Search to detect cycle in an undirected graph
     * @param source current node
     * @param patent parent node
     * @param visited visited array
     * @param adj adjacency list
     * @return true if cycle is detected, false otherwise
     * Approach:
     * 1. Mark the current node as visited.
     * 2. For each neighbor of the current node:
     *    a. If the neighbor is not visited, recursively perform DFS on it.
     *    b. If the neighbor is visited and is not the parent of the current node,
     *       a cycle is detected; return true.
     * 3. If all neighbors are processed without finding a cycle, return false.
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the visited array and recursion stack.
     * Dry Run:
     * Consider a graph with 5 vertices and edges: (0-1), (1-2), (2-0), (1-3), (3-4)
     * Starting DFS from node 0:
     * - visited = [true, false, false, false, false]
     * - From 0, visit neighbor 1:
     *   - visited = [true, true, false, false, false]
     *   - From 1, visit neighbor 0 (parent, ignore), then visit neighbor 2:
     *     - visited = [true, true, true, false, false]
     *     - From 2, visit neighbor 1 (parent, ignore), then visit neighbor 0:
     *       - 0 is visited and not the parent of 2, cycle detected, return true.
     * The function returns true indicating a cycle is present in the graph.
     */
    private static boolean dfs(int source, int patent, boolean[] visited, List<List<Integer>> adj) {
        visited[source] = true;
        for (Integer neighbor : adj.get(source)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, source, visited, adj)) {
                    return true;
                }
            } else if (neighbor != patent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = List.of(
                List.of(1, 2),
                List.of(0, 3),
                List.of(0, 3),
                List.of(1, 2, 4),
                List.of(3)
        );

        boolean hasCycle = isCycle(v, adj);
        System.out.println("Graph contains cycle: " + hasCycle);
    }
}
