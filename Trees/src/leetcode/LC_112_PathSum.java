package leetcode;

public class LC_112_PathSum {
    /**
     * Path Sum
     * Given the root of a binary tree and an integer targetSum, return true if there is a root-to-leaf path in the tree such that adding up all the values along the
     * path equals targetSum. A leaf is a node with no children.
     * @param root - root of the binary tree
     * @param targetSum - target sum to be checked
     * Approach:
     *             1. If the root is null, return false.
     *             2. Initialize a variable sum to 0.
     *             3. Call the helper function pathSumHelper with root, sum and targetSum.
     *             4. In the helper function, if the root is null, return false.
     *             5. Add the value of the current node to sum.
     *             6. If the current node is a leaf node, check if sum is equal to targetSum. If yes, return true.
     *             7. Recursively call the helper function for the left and right subtrees.
     *             8. Return true if either of the recursive calls return true.
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(h) where h is the height of the tree (due to recursion stack).
     * Dry Run:
     * Consider the following binary tree and targetSum = 22:
     *         5
     *        / \
     *       4   8
     *      /   / \
     *     11  13  4
     *    /  \      \
     *   7    2      1
     * The path 5 -> 4 -> 11 -> 2 sums to 22.
     * 1. Start at the root (5), sum = 0 + 5 = 5.
     * 2. Move to the left child (4), sum = 5 + 4 = 9.
     * 3. Move to the left child (11), sum = 9 + 11 = 20.
     * 4. Move to the left child (7), sum = 20 + 7 = 27 (not a leaf).
     * 5. Backtrack to (11) and move to the right child (2), sum = 20 + 2 = 22 (leaf node, matches targetSum).
     * 6. Return true.
     * The function returns true as there exists a root-to-leaf path with the sum equal to targetSum.
     * @return true if there is a root-to-leaf path with sum equal to targetSum, false otherwise.
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int sum = 0;
        boolean hasPath = pathSumHelper(root, sum, targetSum);
        return hasPath;
    }

    private static boolean pathSumHelper(TreeNode root, int sum, int targetSum) {
        if (root == null)
            return false;

        sum = sum + root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        return pathSumHelper(root.left, sum, targetSum) || pathSumHelper(root.right, sum, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum));
    }
}
