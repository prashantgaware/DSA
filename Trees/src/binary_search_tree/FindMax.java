package binary_search_tree;

import java.util.List;

public class FindMax {
    /**
     *
     * @param root
     * @return
     * Approach:
     * 1. Start at the root node.
     * 2. If the current node is null, return null indicating the tree is empty.
     * 3. If the current node's right child is null, return the current node as it contains the maximum value.
     * 4. Otherwise, recursively search in the right subtree.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(h) for the recursive stack space.
     */
    public static BSTreeNode findMaxRec(BSTreeNode root) {
        if (root == null)
            return null;
        else {
            if (root.right == null)
                return root;
            else
                return findMaxRec(root.right);
        }
    }

    /**
     *
     * @param root
     * @return
     * Approach:
     * 1. Start at the root node.
     * 2. If the current node is null, return null indicating the tree is empty.
     * 3. While the current node is not null:
     * 4. If the current node's right child is null, return the current node as it contains the maximum value.
     * 5. Otherwise, move to the right child.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(1) for the iterative approach.
     */
    public static BSTreeNode findMax(BSTreeNode root) {
        if (root == null)
            return null;

        while (root != null) {
            if (root.right == null) {
                return root;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BSTreeNode root = BST_Implementation.buildBST(List.of(10, 5, 15, 3, 7, 12, 18));
        System.out.println("Maximum value (recursive): " + findMaxRec(root).data);
        System.out.println("Maximum value (iterative): " + findMax(root).data);
    }
}
