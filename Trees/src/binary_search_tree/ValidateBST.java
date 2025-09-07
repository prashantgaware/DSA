package binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBST {
    public static boolean isValidBST(BSTreeNode root) {
        Deque<BSTreeNode> stack = new ArrayDeque<>();
        BSTreeNode curr = root, prev = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();

            if (prev != null && curr.data <= prev.data) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }

    // Recursive approach
    public static boolean isValidBSTRec(BSTreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Utility method to validate the BST by ensuring all nodes adhere to the min/max constraints.
     * @param root
     * @param minValue
     * @param maxValue
     * @return true if valid BST, false otherwise
     * Approach: Recursion with min/max constraints
     * 1. If the current node is null, return true (base case)
     * 2. If the current node's value is not within the min/max range, return false
     * 3. Recursively check the left subtree with updated max value (current node's value)
     * 4. Recursively check the right subtree with updated min value (current node's value)
     * 5. Return true if both subtrees are valid
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
     */
    private static boolean isValidBSTUtil(BSTreeNode root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data <= minValue || root.data >= maxValue)
            return false;

        return isValidBSTUtil(root.left, minValue, root.data) &&
               isValidBSTUtil(root.right, root.data, maxValue);
    }

    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(2);
        root.left = new BSTreeNode(1);
        root.right = new BSTreeNode(3);

        boolean isValid = isValidBST(root);
        System.out.println("Is the binary search tree valid? " + isValid);

        // invalid BST
        BSTreeNode invalidRoot = new BSTreeNode(5);
        invalidRoot.left = new BSTreeNode(1);
        invalidRoot.right = new BSTreeNode(4);
        invalidRoot.right.left = new BSTreeNode(3);
        invalidRoot.right.right = new BSTreeNode(6);

        isValid = isValidBST(invalidRoot);
        System.out.println("Is the binary search tree valid? " + isValid);
        System.out.println("Is the BST valid (Recursion): " + isValidBSTRec(invalidRoot));
        System.out.println("Is the BST valid (Recursion): " + isValidBSTRec(root));
    }
}
