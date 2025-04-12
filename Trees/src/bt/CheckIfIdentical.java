package bt;

public class CheckIfIdentical {
    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        // Base case: if both nodes are null, they are identical
        if (root1 == null && root2 == null) {
            return true;
        }

        // If one of the nodes is null, they are not identical
        if (root1 == null || root2 == null) {
            return false;
        }

        // Check if the current nodes are identical and recursively check their children
        return (root1.data == root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        boolean result = isIdentical(root1, root2);
        System.out.println("Are the two binary trees identical? " + result);
    }
}
