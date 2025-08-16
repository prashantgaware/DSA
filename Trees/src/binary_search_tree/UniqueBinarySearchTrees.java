package binary_search_tree;

public class UniqueBinarySearchTrees {
    /**
     * Calculates the number of unique binary search trees (BSTs) that can be formed with n distinct nodes.
     * @param n the number of distinct nodes
     * @return the number of unique BSTs that can be formed
     * Approach:
     * 1. If n is 0 or 1, there is only one unique BST (the empty tree or a single node).
     * 2. For each node i from 1 to n, consider it as the root of the BST.
     * 3. The left subtree can have i - 1 nodes, and the right subtree can have n - i nodes.
     * 4. The number of unique BSTs with i as the root is the product of the number of unique BSTs that can be formed with the left and right subtrees.
     * 5. Sum the counts for all possible roots (i) to get the total number of unique BSTs.
     * Time Complexity: O(n^2), where n is the number of nodes.
     * Space Complexity: O(n) for the recursion stack.
     */
    public static int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i - 1) * numTrees(n - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of unique BSTs with " + n + " nodes: " + numTrees(n));
    }
}
