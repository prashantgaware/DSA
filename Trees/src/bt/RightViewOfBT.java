package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBT {
    /**
     * Given a binary tree, return the right view of the binary tree.
     * The right view of a binary tree is the set of nodes visible when the tree is
     * viewed from the right side.
     * @param root the root of the binary tree
     * @return a list of integers representing the right view of the binary tree
     * Approach:
     * 1. Use a queue to perform level order traversal of the tree.
     * 2. For each level, keep track of the last node visited.
     * 3. Add the last node of each level to the result list.
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(n) for the queue and the result list.
     * Dry Run:
     * Consider the following binary tree:
     *         1
     *        / \
     *       2   3
     *        \   \
     *         4   5
     *              \
     *               6
     * The right view would be [1, 3, 5, 6].
     * 1. Initialize the queue with the root node.
     * 2. Process each level of the tree:
     *    - For level 0, visit node 1 and add it to the result list.
     *    - For level 1, visit nodes 2 and 3. The last node is 3, add it to the result list.
     *    - For level 2, visit nodes 4 and 5. The last node is 5, add it to the result list.
     *    - For level 3, visit node 6. The last node is 6, add it to the result list.
     * 3. Return the final result list containing the right view of the binary tree.
     */
    public static List<Integer> rightView(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode temp = null;
            for (int i = 0; i < levelSize; i++) {
                temp = q.poll();
                assert temp != null;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            result.add(temp.data);
        }
        return result;
    }

    public static List<Integer> rightViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewUtil(root, result, 1);
        return result;
    }

    private static void rightViewUtil(TreeNode root, List<Integer> result, int levelSize) {
        if (root == null) {
            return;
        }

        if (levelSize > result.size()) {
            result.add(root.data);
        }

        // first visit the right subtree, then the left subtree
        // Reason being we want the rightmost node at each level
        rightViewUtil(root.right, result, levelSize + 1);
        rightViewUtil(root.left, result, levelSize + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        List<Integer> rightView = rightView(root);
        System.out.println("Right View of Binary Tree: " + rightView);
        List<Integer> rightViewRec = rightViewRecursive(root);
        System.out.println("Right View of Binary Tree (Recursive): " + rightViewRec);
    }
}
