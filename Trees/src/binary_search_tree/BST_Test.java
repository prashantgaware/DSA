package binary_search_tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BST_Test {
    public static void main(String[] args) {
        TreeNode root = BST_Implementation.buildBST(
                new ArrayList<>() {
                    {
                        add(10);
                        add(5);
                        add(2);
                        add(1);
                        add(4);
                        add(15);
                        add(3);
                        add(7);
                        add(12);
                    }
                }
        );

        System.out.println("Binary Search Tree (BST) In-Order Traversal:");
        BST_Implementation.printTree(root);
        System.out.println();

        System.out.println("Searching for 7 in BST: " + BST_Implementation.search(root, 7));
        System.out.println("Deleting 5 from BST...");
        root = BST_Implementation.delete(root, 5);
        System.out.println("Binary Search Tree (BST) In-Order Traversal after deletion:");
        BST_Implementation.printTree(root);
    }
}
