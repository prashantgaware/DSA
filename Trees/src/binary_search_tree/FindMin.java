package binary_search_tree;

import java.util.List;

public class FindMin {
    /**
     *
     * @param root
     * @return
     * Approach:
     * 1. Start at the root node.
     * 2. If the current node is null, return null indicating the tree is empty.
     * 3. If the current node's left child is null, return the current node as it contains the minimum value.
     * 4. Otherwise, recursively search in the left subtree.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(h) for the recursive stack space.
     */
    private static BSTreeNode findMinRec(BSTreeNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.left == null)
                return root;
            else
                return findMinRec(root.left);
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
     * 4. If the current node's left child is null, return the current node as it contains the minimum value.
     * 5. Otherwise, move to the left child.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(1) for the iterative approach.
     */
    public static BSTreeNode findMin(BSTreeNode root) {
        if (root == null)
            return null;

        while (root != null) {
            if (root.left == null) {
                return root;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BSTreeNode root = BST_Implementation.buildBST(List.of(10, 5, 15, 3, 7, 12, 18));
        System.out.println("Minimum value (recursive): " + findMinRec(root).data);
        System.out.println("Minimum value (iterative): " + findMin(root).data);
    }
}
