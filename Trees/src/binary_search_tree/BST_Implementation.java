package binary_search_tree;

import com.sun.source.tree.Tree;

import java.util.List;

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST_Implementation {

    public static TreeNode buildBST(List<Integer> nodes) {
        TreeNode root = null;
        for (int val : nodes) {
            root = insert(root, val);
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static boolean search(TreeNode root, int value) {
        if (root == null)
            return false;

        if (root.data == value)
            return true;

        if (value < root.data)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                TreeNode minNode = root.right;
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
