package striver.traversal;

import java.util.ArrayList;
import java.util.List;

public class DFS_Traversal {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);

        int v = 5;
        List<Integer> dfsResult = dfsOfGraph(v, adj);
        System.out.println("DFS Traversal: " + dfsResult);
    }

    public static List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        List<Integer> ls = new ArrayList<>();
        visited[0] = true;
//        ls.add(0);
        dfs(0, visited, adj, ls);
        return ls;
    }

    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> ls) {
        ls.add(node);
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                dfs(neighbour, visited, adj, ls);
            }
        }
    }
}
