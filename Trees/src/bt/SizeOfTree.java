package bt;

public class SizeOfTree {
    private static int size(TreeNode root) {
        if (root != null) {
            return size(root.left) + size(root.right) + 1;
        }

        return 0;
    }
}
