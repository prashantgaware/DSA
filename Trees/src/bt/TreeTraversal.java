package bt;

import java.util.Stack;

public class TreeTraversal {
    /**
     * Preorder traversal
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Visit the root node first,
     *             then recursively traverse the left subtree and
     *             then the right subtree
     *
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.left);
            preOrder(root.right);
        }

        return;
    }

    /**
     * Preorder traversal using iterative approach
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Visit the root node first,
     *             then traverse the left subtree and
     *             then the right subtree
     */
    public void preOrderIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.getData());
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    /**
     * Inorder traversal
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Traverse the left subtree first,
     *             then visit the root node and
     *             then traverse the right subtree
     */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.getData());
            inorder(root.right);
        }

        return;
    }

    /**
     * Inorder traversal using iterative approach
     * @param root root node of the tree
     *             Approach:
     *             Traverse the left subtree first,
     *             then visit the root node and
     *             then
     */
    public void inorderIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.getData());
            temp = temp.right;
        }
    }

    /**
     * Postorder traversal
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Traverse the left subtree first,
     *              then the right subtree and
     *             then visit the root node
     */
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.getData());
        }
    }
}
