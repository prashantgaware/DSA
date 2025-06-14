package bt;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeInBinaryTree {
    public static TreeNode deepestNode(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }

        return currentNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Deepest node value: " + deepestNode(root).data);
    }
}
