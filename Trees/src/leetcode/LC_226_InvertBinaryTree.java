package leetcode;

public class LC_226_InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = invertTree(root);

        System.out.println("\nInverted Tree:");
        printTree(invertedRoot, 0);
    }

    private static void printTree(TreeNode root, int level) {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println(" ".repeat(level * 4) + root.val);
        printTree(root.left, level + 1);
    }
}
