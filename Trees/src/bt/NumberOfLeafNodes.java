package bt;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeafNodes {
    /**
     * Counts the number of leaf nodes in a binary tree using level order traversal.
     * @param root the root of the binary tree
     * @return the number of leaf nodes in the tree
     * Approach: Level Order Traversal
     * 1. If the root is null, return 0.
     * 2. Initialize a queue and add the root node to it.
     * 3. While the queue is not empty, poll a node from the queue.
     * 4. If the node is a leaf (both left and right children are null), increment the count.
     * 5. If the node has a left child, add it to the queue.
     * 6. If the node has a right child, add it to the queue.
     * 7. Return the count of leaf nodes.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(w), where w is the maximum width of the tree (due to queue).
     */
    public static int countLeafNodesUsingLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left == null && temp.right == null)
                count++;
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }

        return count;
    }

    /**
     * Counts the number of leaf nodes in a binary tree using recursion.
     * @param root the root of the binary tree
     * @return the number of leaf nodes in the tree
     * Approach: Recursion
     * 1. If the root is null, return 0.
     * 2. If the node is a leaf (both left and right children are null), return 1.
     * 3. If the node is not a leaf, recursively count the leaf nodes in the left and right subtrees.
     * 4. Return the sum of the leaf nodes from both subtrees.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     */
    public static int countLeafNodesUsingRecursion(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftCount = countLeafNodesUsingRecursion(root.left);
        int rightCount = countLeafNodesUsingRecursion(root.right);

        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int leafCountLevelOrder = countLeafNodesUsingLevelOrderTraversal(root);
        System.out.println("Number of leaf nodes (Level Order): " + leafCountLevelOrder);

        int leafCountRecursion = countLeafNodesUsingRecursion(root);
        System.out.println("Number of leaf nodes (Recursion): " + leafCountRecursion);
    }
}
