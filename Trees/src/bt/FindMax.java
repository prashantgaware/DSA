package bt;

public class FindMax {
    private static int findMaxInBT(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int max;
        int leftMax = findMaxInBT(root.left);
        int rightMax = findMaxInBT(root.right);
        if (leftMax > rightMax)
            max = leftMax;
        else
            max = rightMax;
        if (root.data > max)
            max = root.data;

        return max;
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

        System.out.println("Max element in the binary tree is: " + findMaxInBT(root));
    }
}
