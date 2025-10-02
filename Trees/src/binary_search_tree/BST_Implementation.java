package binary_search_tree;

import java.util.List;

public class BST_Implementation {

    public static BSTreeNode buildBST(List<Integer> nodes) {
        BSTreeNode root = null;
        for (int val : nodes) {
            root = insert(root, val);
        }

        return root;
    }

    public static void printTree(BSTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static BSTreeNode insert(BSTreeNode root, int value) {
        if (root == null) {
            root = new BSTreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static boolean search(BSTreeNode root, int value) {
        if (root == null)
            return false;

        if (root.data == value)
            return true;

        if (value < root.data)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    public static BSTreeNode delete(BSTreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                BSTreeNode minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }

                // Copy the inorder successor's content to this node
                root.data = minNode.data;

                // Delete the inorder successor
                root.right = delete(root.right, minNode.data);
            }
        }

        return root;
    }
}
