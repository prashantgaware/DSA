package leetcode;
/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
        -1000 <= Node.val <= 1000
*/

import bt.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_102_BinaryTreeLevelOrderTraversal_1 {
    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = q.poll();
                assert temp != null;
                currentLevel.add(temp.getData());
                if (temp.getLeft() != null) {
                    q.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    q.offer(temp.getRight());
                }
            }
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        // Constructing the binary tree using TreeNode class
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        // Setting up the tree structure
        root.setLeft(node9);
        root.setRight(node20);
        node20.setLeft(node15);
        node20.setRight(node7);

        List<List<Integer>> result = levelOrderTraversal(root);
        System.out.println("Level Order Top-Down Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
