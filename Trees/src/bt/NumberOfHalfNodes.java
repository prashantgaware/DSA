package bt;

import java.util.LinkedList;
import java.util.Queue;

// half node is a node that has exactly one child (either left or right)
public class NumberOfHalfNodes {
    /**
     * Count half nodes in a binary tree using level order traversal.
     * @param root the root of the binary tree
     * @return the count of half nodes
     * Approach:
     * 1. If the root is null, return 0.
     * 2. Use a queue to perform level order traversal.
     * 3. For each node, check if it has only one child (either left or right).
     * 4. If it has only one child, increment the count.
     * 5. Return the total count of half nodes.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), for storing nodes in the queue.
     */
    static int countHalfNodes(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if ((temp.left != null && temp.right == null) || (temp.right != null && temp.left == null))
                count++;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

        return count;
    }

    /**
     * Count half nodes in a binary tree using recursion.
     * @param root the root of the binary tree
     * @return the count of half nodes
     * Approach:
     * 1. If the root is null, return 0.
     * 2. If the node has only one child (either left or right), count it as a half node.
     * 3. Recursively count half nodes in the left and right subtrees.
     * 4. Return the sum of half nodes from both subtrees.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     */
    static int countHalfNodeUsingRecursion(TreeNode root) {
        if (root == null)
            return 0;

        if ((root.left != null && root.right == null) || (root.right != null && root.left == null))
            return 1;

        int leftCount = countHalfNodes(root.left);
        int rightCount = countHalfNodes(root.right);

        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int halfNodesCount = countHalfNodes(root);
        System.out.println("Number of half nodes: " + halfNodesCount);

        int halfNodesCountRecursion = countHalfNodeUsingRecursion(root);
        System.out.println("Number of half nodes using recursion: " + halfNodesCountRecursion);
    }
}
