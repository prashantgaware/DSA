package basics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CycleDetectionInUndirectedGraphUsingBFS {

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

    public static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (bfsCheck(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Algorithm:
     * 1. Initialize a queue for BFS and mark the source node as visited.
     * 2. While the queue is not empty, do the following:
     *    a. Dequeue a node from the queue and get its parent node.
     *    b. For each neighbor of the dequeued node, do the following:
     *       i. If the neighbor is not visited, mark it as visited and enqueue it with the current node as its parent.
     *       ii. If the neighbor is visited and is not the parent of the current node, a cycle is detected; return true.
     * 3. If the queue is exhausted without finding a cycle, return false.
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the visited array and the queue.
     * Dry Run:
     * Consider a graph with 5 vertices and edges: (0-1), (1-2), (2-0), (1-3), (3-4)
     * Starting BFS from node 0:
     * - Enqueue (0, -1), visited = [true, false, false, false, false]
     * - Dequeue (0, -1), neighbors = [1]
     *   - Enqueue (1, 0), visited = [true, true, false, false, false]
     * - Dequeue (1, 0), neighbors = [0, 2, 3]
     *   - 0 is visited and is the parent, continue
     *   - Enqueue (2, 1), visited = [true, true, true, false, false]
     *   - Enqueue (3, 1), visited = [true, true, true, true, false]
     * - Dequeue (2, 1), neighbors = [1, 0]
     *   - 1 is visited and is the parent, continue
     *   - 0 is visited and is not the parent, cycle detected, return true
     */
    private static boolean bfsCheck(int source, List<List<Integer>> adj, boolean[] visited) {
        visited[source] = true;
        // create a queue for BFS
        Queue<Pair> queue = new LinkedList<>();
        // add the source node and its parent to the queue
        queue.offer(new Pair(source, -1));
        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.poll();
            for (Integer neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour, node));
                } else if (parent != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

}
