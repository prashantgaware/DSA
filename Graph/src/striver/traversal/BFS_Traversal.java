package striver.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Traversal {
    public static List<Integer> bfsTraversal(int v, List<Integer> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for (int neighbour : adj) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        List<Integer> adj = new ArrayList<>();
        adj.add(1);
        adj.add(2);
        adj.add(3);
        adj.add(4);
        adj.add(5);

        int v = 6;
        List<Integer> bfsResult = bfsTraversal(v, adj);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
