package bt;

public class SubtreeOfTree {

    /**
     * Check if subRoot is a subtree of root
     * @param root root of the main tree
     * @param subRoot root of the subtree to check
     * @return true if subRoot is a subtree of root, false otherwise
     * Approach:
     * 1. If root is null, return false.
     * 2. If subRoot is null, return true (an empty tree is a subtree of any tree).
     * 3. If the data of root and subRoot match, check if they are identical using isIdentical.
     * 4. Recursively check the left and right subtrees of root to see if subRoot is a subtree of either.
     * * Time Complexity: O(N * M) where N is the number of nodes in root and M is the number of nodes in subRoot.
     * * Space Complexity: O(H) where H is the height of the tree due to recursion stack.
     */
    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (subRoot == null)
            return true;

        if (root.data == subRoot.data && isIdentical(root, subRoot))
            return true;

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.data == root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println("Is subRoot a subtree of root? " + isSubTree(root, subRoot));

        TreeNode nonSubRoot = new TreeNode(6);
        System.out.println("Is nonSubRoot a subtree of root? " + isSubTree(root, nonSubRoot));
    }
}
