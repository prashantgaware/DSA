package bt;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LevelWithMaxSum {
    /**
     * This method finds the level in a binary tree that has the maximum sum of node values.
     * @param root the root of the binary tree
     * @return the level with the maximum sum, or -1 if the tree is empty
     * Approach:
     * 1. Use a queue to perform a level order traversal of the tree.
     * 2. For each level, calculate the sum of the node values.
     * 3. Keep track of the maximum sum encountered and the corresponding level.
     * Time Complexity: O(N) where N is the number of nodes in the tree, as we visit each node once.
     * Space Complexity: O(W) where W is the maximum width of the tree, which is the maximum number of nodes at any level.
     */
    public static int findLevelWithMaxSum(TreeNode root) {
        if (root == null)
            return -1;

        int maxSum = Integer.MIN_VALUE;
        int levelWithMaxSum = -1;
        int currentLevel = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int currentLevelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                currentLevelSum = currentLevelSum + Objects.requireNonNull(currentNode).data;

                if (currentNode.left != null)
                    q.offer(currentNode.left);
                if (currentNode.right != null)
                    q.offer(currentNode.right);
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                levelWithMaxSum = currentLevel;
            }
            currentLevel++;
        }

        return levelWithMaxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int levelWithMaxSum = findLevelWithMaxSum(root);
        System.out.println("Level with maximum sum: " + levelWithMaxSum);
    }
}
