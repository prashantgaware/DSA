package bt;

public class DiameterOfBT {
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currentDiameter = leftHeight + rightHeight;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Optimized version of diameter calculation using height
     * Approach:
     * 1. Use a helper function to calculate the height of the tree while also updating the diameter.
     * 2. The height function returns the height of the current node and updates a global variable for diameter.
     * This avoids the need to traverse the tree multiple times.
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree due to recursion stack.
     */
    static int diameter = 0;
    public static int diameterOfBinaryTreeOptimized(TreeNode root) {
        heightOptimized(root);
        return diameter;
    }

    private static int heightOptimized(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = heightOptimized(root.left);
        int rightHeight = heightOptimized(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);

        int optimizedDiameter = diameterOfBinaryTreeOptimized(root);
        System.out.println("Optimized Diameter of the binary tree: " + optimizedDiameter);
    }
}
