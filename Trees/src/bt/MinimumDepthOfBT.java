package bt;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBT {
    /**
     * Finds the minimum depth of a binary tree.
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     * Approach: Recursion
     * 1. If the root is null, return 0.
     * 2. If the node is a leaf (both left and right children are null), return 1.
     * 3. If one child is null, return the depth of the other child plus one.
     * 4. If both children are present, return the minimum depth of the two children plus one.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     */
    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * Finds the minimum depth of a binary tree using level order traversal.
     * @param root the root of the binary tree
     * @return the minimum depth of the tree
     * Approach: Level Order Traversal
     * 1. Use a queue to traverse the tree level by level.
     * 2. Start from the root and explore all nodes at the current depth before moving on to nodes at the next depth level.
     * 3. The first time a leaf node (a node with no children) is encountered, return the current depth.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n) in the worst case, where n is the number of nodes in the tree (if the tree is skewed).
     */
    private static int minDepthUsingLevelOrderTraversal(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                assert current != null;
                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(11);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);

        System.out.println("Minimum depth of tree : " + minDepth(root));
        System.out.println("Minimum depth of tree using level order traversal: " + minDepthUsingLevelOrderTraversal(root));
    }
}
