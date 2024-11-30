package bt;

import java.util.LinkedList;
import java.util.Queue;

public class FindMax {
    private static int maxInBT(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxInBT(root.left);
            int rightMax = maxInBT(root.right);
            if (leftMax > rightMax)
                max = leftMax;
            else
                max = rightMax;

            if (root.data > max)
                max = root.data;
        }

        return max;
    }

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

    private static int findMaxInBTIterative(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.getData() > max)
                max = temp.getData();
            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());
            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

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

        System.out.println("Max element in the binary tree is: " + maxInBT(root));
        System.out.println("Max element in the binary tree is: " + findMaxInBT(root));
        System.out.println("Max element using iterative approach in the binary tree is: " + findMaxInBTIterative(root));
    }
}
