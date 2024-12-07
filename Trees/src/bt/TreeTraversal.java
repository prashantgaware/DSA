package bt;

import java.util.ArrayList;
import java.util.List;
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
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
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
    public static void preOrderIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.getData() + " ");
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
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.getData() + " ");
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
    public static void inorderIterative(TreeNode root) {
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
            System.out.print(temp.getData() + " ");
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
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * Postorder traversal using iterative approach
     * @param root root node of the tree
     *             Time complexity: O(n)
     *             Space complexity: O(n)
     *             Approach:
     *             Traverse the left subtree first,
     *              then the right subtree and
     *             then visit the root node
     */
    public static List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            output.push(current);
            if (current.left != null) {
                stack.push(current.left);
            } if (current.right != null) {
                stack.push(current.right);
            }
        }
        while (!output.isEmpty()) {
            result.add(output.pop().data);
        }
        return result;
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

        System.out.println("Pre order recursive : ");
        preOrder(root);
        System.out.println();

        System.out.println("Pre order iterative : ");
        preOrderIterative(root);
        System.out.println();

        System.out.println("In order recursive : ");
        inorder(root);
        System.out.println();

        System.out.println("In order iterative : ");
        inorderIterative(root);
        System.out.println();

        System.out.println("Post order recursive : ");
        postOrder(root);
        System.out.println();

        System.out.println("Post order iterative : ");
        List<Integer> postIterative = postOrderIterative(root);
        for (int i : postIterative)
            System.out.print(i + " ");
    }
}
