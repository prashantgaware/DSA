package bt;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public static int maxDepthDFS(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepthDFS(root.left);
        int rightDepth = maxDepthDFS(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /*
        1. Handle Empty Tree: If the root is null, it means the tree is empty, and its depth is 0.
        2. Initialize Queue and Depth: A Queue (implemented by LinkedList) is used to store nodes to visit.
            The depth variable is initialized to 0.
        3. Add Root: The root node is added to the queue to begin the traversal.
        4. Level-by-Level Traversal:
            4.1. The while (!queue.isEmpty()) loop continues as long as there are nodes to process.
            4.2. depth++: At the beginning of each iteration of the outer while loop, we increment depth.
                This signifies that we are moving to (or starting to process) a new level in the tree.
            4.3. int levelSize = queue.size(): Before processing nodes, we capture the current size of the queue.
                This is vital because the queue will grow as we add children of the current level's nodes. By knowing the levelSize, we ensure that the inner for loop only processes the nodes that belong to the current depth level.
        5. Process Current Level Nodes: The for loop iterates levelSize times. In each iteration:
            5.1. queue.poll(): A node from the current level is removed from the queue.
            5.2. Add Children: Its left and right children (if they exist) are added to the queue.
                These children will be processed in the next iteration of the outer while loop, contributing to the depth+1 level.
        6. Return Depth: Once the while loop finishes (meaning all nodes have been visited and the queue is empty),
            the depth variable will hold the maximum depth of the tree.
    */
    public static int maxDepthBFS(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (curr.left != null)
                        queue.offer(curr.left);
                    if (curr.right != null)
                        queue.offer(curr.right);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Max Depth (DFS): " + maxDepthDFS(root));
        System.out.println("Max Depth (BFS): " + maxDepthBFS(root));
    }
}
