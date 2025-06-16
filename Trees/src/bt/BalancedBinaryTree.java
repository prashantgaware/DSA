package bt;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = heightOfBT(root.left);
        int rightHeight = heightOfBT(root.right);

        return Math.abs(leftHeight - rightHeight) < 1;
    }

    private static int heightOfBT(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfBT(root.left);
        int rightHeight = heightOfBT(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Is the binary tree balanced? " + isBalanced(root));

        // Adding an unbalanced node
        root.left.left.left = new TreeNode(7);
        System.out.println("Is the binary tree balanced? " + isBalanced(root));
    }
}
