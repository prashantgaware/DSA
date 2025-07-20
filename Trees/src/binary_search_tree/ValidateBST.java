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
    }
}
