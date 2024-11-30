package bt;

public class SearchElementInBT {
    private static boolean searchElementInBT(TreeNode root, int data) {
        if (root == null)
            return false;
        if (root.getData() == data)
            return true;

        return (searchElementInBT(root.left,data) || searchElementInBT(root.right,data));
    }

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

        System.out.println(searchElementInBT(root, 11));
    }
}
