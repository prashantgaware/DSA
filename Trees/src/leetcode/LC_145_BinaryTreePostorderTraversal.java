package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_145_BinaryTreePostorderTraversal {
    /**
     * Postorder traversal of a binary tree
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Traverse the left subtree, then the right subtree,
     *             and finally visit the root node.
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        dfs(root, out);
        return out;
    }

    /**
     * Helper method to perform DFS traversal
     * @param root current node
     * @param out list to store the postorder traversal result
     *            Approach:
     *            Recursively traverse the left and right subtrees,
     *            and then add the current node's value to the list.
     *            Time complexity: O(n)
     *            Space complexity: O(n) for the output list
     */
    private static void dfs(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        dfs(root.left, out);
        dfs(root.right, out);
        out.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
    }
}
