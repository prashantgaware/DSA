package bt;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree {
    private static int size(TreeNode root) {
        if (root != null) {
            return size(root.left) + size(root.right) + 1;
        }

        return 0;
    }

    private static int sizeUsingLevelOrderTraversal(TreeNode root) {
        int count = 0;
        if (root == null) return count;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            count++;
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }

        return count;
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

        System.out.println("Size of tree: " + sizeUsingLevelOrderTraversal(root));
    }
}
