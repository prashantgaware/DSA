package basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    public static void bfs(int i, boolean[] vis, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = true;
        while (!queue.isEmpty()) {
            Integer curr_element = queue.poll();
            for (Integer neighbour : adjList.get(curr_element)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static int countIslands(int[][] adjMatrix, int edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] adj : adjMatrix) {
            adjList.get(adj[0]).add(adj[1]);
            adjList.get(adj[1]).add(adj[0]);
        }

        boolean[] vis = new boolean[edges];
        int count = 0;
        for(int i = 0; i < edges; i++) {
            if (!vis[i]) {
                count++;
                bfs(i, vis, adjList);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };
        int edges = 5;
        System.out.println("Number of Islands: " + countIslands(adjMatrix, edges));
    }
}
