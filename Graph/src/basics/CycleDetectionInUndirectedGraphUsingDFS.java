package basics;

import java.util.List;

public class CycleDetectionInUndirectedGraphUsingDFS {

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
