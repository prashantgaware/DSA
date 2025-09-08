package bt;

import java.util.Stack;

public class CountNodesInCompleteTree {
    /**
     * Count the number of nodes in cbt
     * @param root - root of the binary tree
     * @return
     * Approach:
     * 1. If the root is null, return 0.
     * 2. Initialize count to 1 (to count the root node).
     * 3. Recursively call countNodes on the left subtree and add the result to count.
     * 4. Recursively call countNodes on the right subtree and add the result to count.
     * 5. Return the total count.
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(h) where h is the height of the tree (due to recursion stack).
     */
    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }

    public static int countNodesUsingInorder(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        return inOrder(root, count);
    }

    public static int inOrder(TreeNode root, int count) {
        if (root == null)
            return count;
        count = inOrder(root.left, count);
        count++;
        count = inOrder(root.right, count);
        return count;
    }

    // Iterative approach using stack
    public static int countNodesIterative(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
        System.out.println(countNodesUsingInorder(root));
        System.out.println(countNodesIterative(root));
    }
}
