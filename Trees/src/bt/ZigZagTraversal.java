package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    private static void zigZagTraversal(TreeNode root) {
        if (root == null)
            return;

        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) {
                    levelNodes.add(currentNode.data);
                } else {
                    levelNodes.add(0, currentNode.data);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            for (int node : levelNodes) {
                System.out.print(node + " ");
            }
            System.out.println();

            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        zigZagTraversal(root);
    }
}
