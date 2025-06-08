package leetcode;

import bt.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_111_MinimumDepthOfBinaryTree {

    /**
     *
     * @param root
     * @return
     * Approach: Depth First Search (DFS)
     * This approach recursively traverses the tree to find the minimum depth.
     * It checks if the current node is null, and if so, returns 0.
     * If a node has no left child, it recursively calculates the depth of the right subtree and vice versa.
     * If both children exist, it returns the minimum of the two depths plus one for the current node.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     */
    public static int minDepthDFS(TreeNode root) {
        if (root == null)
            return 0;

        if (root.getLeft() == null)
            return minDepthDFS(root.getRight()) + 1;
        if (root.getRight() == null)
            return minDepthDFS(root.getLeft()) + 1;

        return Math.min(minDepthDFS(root.getLeft()), minDepthDFS(root.getRight())) + 1;
    }

    /**
     *
     * @param root
     * @return
     * Approach: Level Order Traversal (BFS)
     * This approach uses a queue to traverse the tree level by level.
     * It starts from the root and explores all nodes at the present depth prior to moving on to nodes at the next depth level.
     * The first time it encounters a leaf node (a node with no children), it returns the current depth.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     */
    public static int minDepthBFS(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.getLeft() == null && currentNode.getRight() == null)
                    return depth;

                if (currentNode.getLeft() != null)
                    queue.add(currentNode.getLeft());
                if (currentNode.getRight() != null)
                    queue.add(currentNode.getRight());
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));

        System.out.println("Minimum Depth (DFS): " + minDepthDFS(root));
        System.out.println("Minimum Depth (BFS): " + minDepthBFS(root));
    }
}
