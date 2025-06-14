package bt;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBT {
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

        insertInBT(root, 10);
        printTree(root);
        System.out.println();
        insertInBTIterative(root, 12);
        printTree(root);
        System.out.println();
        insertInBTRecursive(root, 15);
        printTree(root);
    }

    // This code is valid only for BST, not for BT.
    private static TreeNode insertInBT(TreeNode root, int k) {
        if (root == null)
            return new TreeNode(k);

        if (k < root.data)
            root.left = insertInBT(root.left, k);
        else
            root.right = insertInBT(root.right, k);

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    /**
     * Insert a node in Binary Tree iteratively.
     * @param root The root of the binary tree.
     * @param k The value to be inserted.
     * @return The root of the binary tree after insertion.
     * Approach:
     * 1. If the root is null, create a new node with value k and return it.
     * 2. Use a queue to perform level order traversal.
     * 3. Traverse the tree level by level until you find a node that has an empty left or right child.
     * 4. Insert the new node as the left child if the left child is empty, otherwise insert it as the right child.
     * 5. Return the root of the tree.
     */
    public static TreeNode insertInBTIterative(TreeNode root, int k) {
        TreeNode newNode = new TreeNode(k);
        if (root == null)
            return newNode;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                q.offer(temp.left);
            } else {
                temp.left = new TreeNode(k);
                return root;
            }

            if (temp.right != null) {
                q.offer(temp.right);
            } else {
                temp.right = new TreeNode(k);
                return root;
            }
        }

        return root;
    }

    /**
     * Insert a node in Binary Tree recursively.
     * @param root The root of the binary tree.
     * @param k The value to be inserted.
     * @return The root of the binary tree after insertion.
     * Approach:
     * 1. If the root is null, create a new node with value k and return it.
     * 2. If the left child is null, insert the new node as the left child.
     * 3. If the right child is null, insert the new node as the right child.
     * 4. If both children are present, recursively call the function on the left child.
     */
    public static TreeNode insertInBTRecursive(TreeNode root, int k) {
        if (root == null) {
            return new TreeNode(k);
        }

        if (root.left == null) {
            root.left = new TreeNode(k);
        } else if (root.right == null) {
            root.right = new TreeNode(k);
        } else {
            // If both children are present, insert in the left subtree
            insertInBTRecursive(root.left, k);
        }

        return root;
    }
}
