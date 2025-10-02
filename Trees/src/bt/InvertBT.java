package bt;

public class InvertBT {
    /**
     * Invert a binary tree.
     * @param root - root of the binary tree
     * Approach:
     *             1. If the root is null, return.
     *             2. Swap the left and right children of the root.
     *             3. Recursively call invertTree on the left and right subtrees.
     *             4. Return the root of the inverted tree.
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(h) where h is the height of the tree (due to recursion stack).
     */
    public static void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Tree:");
        BTLevelOrderTraversal.levelOrder(root).forEach(System.out::println);

        invertTree(root);

        System.out.println("Inverted Tree:");
        BTLevelOrderTraversal.levelOrder(root).forEach(System.out::println);
    }
}
