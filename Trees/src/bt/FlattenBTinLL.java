package bt;

import java.util.ArrayList;
import java.util.List;

public class FlattenBTinLL {
    /**
     * Flatten a binary tree to a linked list using a brute force approach.
     * @param root the root of the binary tree
     * Approach:
     *             1. Traverse the tree and store the nodes in a list.
     *             2. Iterate through the list and set the left child of each node to null
     *             and the right child to the next node in the list.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static void flattenUsingListBrute(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        insertion(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode current = list.get(i);
            TreeNode next = list.get(i + 1);
            current.left = null;
            current.right = next;
        }
    }

    private static void insertion(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        insertion(root.left, list);
        insertion(root.right, list);
    }

    /**
     * Flatten a binary tree to a linked list using a better approach.
     * @param root the root of the binary tree
     *             Approach:
     *             1. Recursively flatten the left and right subtrees.
     *             2. Set the right child of the current node to the left child.
     *
     *             3. Set the left child of the current node to null.
     *             4. Find the rightmost node of the new right subtree and
     *             set its right child to the original right subtree.
     *             
     */
    static void flattenBTBetter(TreeNode root) {
        if (root == null)
            return;

        flattenBTBetter(root.left);
        flattenBTBetter(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flattenUsingListBrute(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
}
