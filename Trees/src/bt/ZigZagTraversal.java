package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    /**
     * ZigZag Traversal of a binary tree.
     * @param root the root of the binary tree
     * @return a list of lists containing the zigzag level order traversal of the binary tree
     * Approach:
     * 1. Use a queue to perform level order traversal.
     * 2. Use a boolean flag to keep track of the direction of traversal (left to right or right to left).
     * 3. For each level, if the direction is left to right, add the nodes to the list in the order they are visited.
     *   If the direction is right to left, add the nodes to the list in reverse order.
     *   4. Toggle the direction for the next level.
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(n) for the queue and the result list.
     * Dry Run:
     * Consider the following binary tree:
     *         1
     *        / \
     *        2   3
     *       / \ / \
     *      4  5 6  7
     *      The zigzag traversal would be:
     *      Level 0: [1] (left to right)
     *      Level 1: [3, 2] (right to left)
     *      Level 2: [4, 5, 6, 7] (left to right)
     *      Result: [[1], [3, 2], [4, 5, 6, 7]]
     *       The function returns the zigzag level order traversal of the binary tree.
     * 1. Initialize the queue with the root node and set the direction to left to right.
     * 2. Process each level of the tree:
     *    - For level 0, visit node 1 and add it to the list.
     *    - For level 1, visit nodes 2 and 3. Since the direction is right to left, add 3 first then 2.
     *    - For level 2, visit nodes 4, 5, 6, and 7. Since the direction is left to right, add them in the order they are visited.
     * 3. Toggle the direction after each level.
     * 4. Return the final result list containing the zigzag traversal.
     */
    private static List<List<Integer>> zigZagTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                /*
                Level 0: [1]           (left-to-right: add at end)
                Level 1: [3, 2]        (right-to-left: add at front reverses [2,3] → [3,2])
                Level 2: [4, 5, 6, 7]  (left-to-right: add at end)
                 */
                if (leftToRight) {
                    if (currentNode != null) {
                        levelNodes.add(currentNode.data);
                    } else {
                        levelNodes.add(null);
                    }
                } else {
                    if (currentNode != null) {
                        levelNodes.add(0, currentNode.data);
                    } else {
                        levelNodes.add(0, null);
                    }
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(levelNodes);
            leftToRight = !leftToRight;
        }
        return result;
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

        List<List<Integer>> zigZagTraversal = zigZagTraversal(root);
        for (int i = 0; i < zigZagTraversal.size(); i++) {
            System.out.println("Level " + i + ": " + zigZagTraversal.get(i));
        }
    }
}
