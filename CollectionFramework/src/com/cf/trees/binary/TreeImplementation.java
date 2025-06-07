package com.cf.trees.binary;

class Node {
    Object data;
    Node left;
    Node right;

    public Node(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeImplementation {
    Node root = null;

    public static void main(String[] args) {
        TreeImplementation tree = new TreeImplementation();
        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        tree.root.right.right = new Node("G");

        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inOrder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrder(tree.root);

        System.out.println("\nHeight of binary tree is " + tree.height(tree.root));
        System.out.println("Size of binary tree is " + tree.size(tree.root));

        System.out.println("Is the binary tree a full binary tree? " + tree.isFullBinaryTree(tree.root));
        System.out.println("Is the binary tree a leaf node? " + tree.isLeaf(tree.root));
    }

    /**
     * This method prints the preorder traversal of the binary tree.
     * @param root - root node of the binary tree
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    private boolean isFullBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (isLeaf(node)) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        return false;
    }
}
