package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    /**
     * Generate all unique binary search trees that store values from 1 to n.
     * @param n the number of nodes in the BST
     * @return a list of all unique BSTs
     * Approach: Recursion
     * 1. If n is 0, return an empty list.
     * 2. For each value i from 1 to n, consider it as the root of the BST.
     * 3. Recursively generate all left subtrees using values from start to i-1,
     *    and all right subtrees using values from i+1 to end.
     * 4. For each combination of left and right subtrees, create a new BST node with value i,
     *    and set its left and right children to the generated left and right subtrees.
     * 5. Add the newly created BST to the list of all trees.
     * 6. Return the list of all unique BSTs.
     * Time Complexity: O(4^n / n^(3/2)), where n is the number of nodes in the BST.
     * Space Complexity: O(n), for storing the list of trees and the recursion stack.
     */
    public static List<BSTreeNode> generateTrees(int n) {
        if (n <= 0) {
            return List.of();
        }

        return buildTrees(1, n);
    }

    /**
     * Helper method to build all unique BSTs for a given range.
     * @param start the starting value of the range
     * @param end the ending value of the range
     * @return a list of all unique BSTs for the range [start, end]
     * Approach:
     * 1. If start is greater than end, return a list containing null (base case).
     * 2. Iterate through each value i from start to end, treating it as the root of the BST.
     * 3. Recursively generate all left subtrees using values from start to i-1,
     *    and all right subtrees using values from i+1 to end.
     * 4. For each combination of left and right subtrees, create a new BST node with value i,
     *    and set its left and right children to the generated left and right subtrees.
     * 5. Add the newly created BST to the list of all trees.
     * 6. Return the list of all unique BSTs for the range [start, end].
     * Time Complexity: O(4^(end - start + 1) / (end - start + 1)^(3/2)),
     * where (end - start + 1) is the number of nodes in the range.
     * Space Complexity: O(n), for storing the list of trees and the recursion stack.
     */
    private static List<BSTreeNode> buildTrees(int start, int end) {
        List<BSTreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<BSTreeNode> leftTrees = buildTrees(start, i - 1);
            List<BSTreeNode> rightTrees = buildTrees(i + 1, end);

            for (BSTreeNode left : leftTrees) {
                for (BSTreeNode right : rightTrees) {
                    BSTreeNode currentNode = new BSTreeNode(i);
                    currentNode.left = left;
                    currentNode.right = right;
                    allTrees.add(currentNode);
                }
            }
        }

        return allTrees;
    }

    public static void main(String[] args) {
        int n = 3;
        List<BSTreeNode> uniqueBSTs = generateTrees(n);
        System.out.println("Number of unique BSTs for n = " + n + ": " + uniqueBSTs.size());
        for (BSTreeNode tree : uniqueBSTs) {
            preOrder(tree);
            System.out.println();
        }
    }

    public static void preOrder(BSTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
