package bt;

public class HeightOfTree {
    private static int height(TreeNode root) {
        if (root == null)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(6);
//        root.left.right.left = new TreeNode(5);
//        root.left.right.right = new TreeNode(11);
//        root.right.right = new TreeNode(9);
//        root.right.right.left = new TreeNode(4);

        System.out.println("Height of tree : " + height(root));
    }
}
