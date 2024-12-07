package bt;

public class InsertInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(11);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);

        insertInBT(root, 10);
        printTree(root);
    }

    private static TreeNode insertInBT(TreeNode root, int k) {
        if (root == null)
            return new TreeNode(k);

        if (k < root.data)
            root.left = insertInBT(root.left, k);
        else
            root.right = insertInBT(root.right, k);

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }
}
