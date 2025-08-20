package leetcode;

/*
LeetCode Problem: 547. Number of Provinces
Problem Link: https://leetcode.com/problems/number-of-provinces/
Description:
There are n cities. Some of them are connected, while some are not.
If city a is connected directly with city b, and city b is connected directly with city c,
then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of that group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
*/

public class LC_547_NumberOfProvinces {

    /**
     *
     * @param isConnected
     * @return
     * Approach:
     * 1. Use Depth First Search (DFS) to explore all cities connected to a given city.
     * 2. Maintain a visited array to keep track of cities that have already
     *    been counted as part of a province.
     * 3. For each unvisited city, perform a DFS to mark all reachable cities
     *    as visited, which counts as one province.
     * 4. Increment the province count each time a new unvisited city is found.
     * Time Complexity: O(n^2), where n is the number of cities (or the size of the matrix).
     * Space Complexity: O(n) for the visited array.
     */
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        System.out.println(findCircleNum(isConnected1));
        System.out.println(findCircleNum(isConnected2));
    }
}
