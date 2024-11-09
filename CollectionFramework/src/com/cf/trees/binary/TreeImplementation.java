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
//        System.out.println(tree.root);
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
}
