package bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindMin {
    /**
     * Find the minimum value in a binary tree using iterative approach
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Traverse the tree using a stack and keep track of the minimum value
     *             If the current node's value is less than the current minimum,
     *             update the minimum value
     *             If the current node has a left child, push it onto the stack
     *             If it has a right child, push it onto the stack
     *             This process continues until all nodes have been visited
     *             Finally, return the minimum value found
     */
    public static int findMin(TreeNode root) {
        if (root == null)
            return -1;

        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.data < min)
                min = curr.data;
            if (curr.left != null)
                stack.push(curr.left);
            if (curr.right != null)
                stack.push(curr.right);
        }

        return min;
    }

    /**
     * Find the minimum value in a binary tree using recursive approach
     * @param root root node of the tree
     * @return minimum value in the tree
     * Approach:
     * Recursively traverse the left and right subtrees
     * Compare the current node's value with the minimum values
     * from the left and right subtrees
     * Return the minimum of the three values
     * Time complexity: O(n)
     * Space complexity: O(h) where h is the height of the tree
     */
    public static int findMinRecursive(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = findMinRecursive(root.left);
        int rightMin = findMinRecursive(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    /**
     * Find the minimum value in a binary tree using level order traversal
     * @param root root node of the tree
     * @return minimum value in the tree
     * Approach:
     * Use a queue to perform level order traversal
     * Iterate through each node in the tree
     * Compare the current node's value with the minimum value found so far
     * Return the minimum value found after traversing all nodes
     * Time complexity: O(n)
     * Space complexity: O(n) for the queue
     */
    public static int findMinLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.data < min)
                min = curr.data;

            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }

        return min;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("Minimum value (iterative): " + findMin(root));
        System.out.println("Minimum value (recursive): " + findMinRecursive(root));
        System.out.println("Minimum value (level order): " + findMinLevelOrderTraversal(root));
    }
}
