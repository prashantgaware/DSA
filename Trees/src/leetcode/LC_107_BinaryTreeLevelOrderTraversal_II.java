package leetcode;
/*
107. Binary Tree Level Order Traversal II

Given the root of a binary tree, return the bottom-up level order traversal
of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
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

import java.util.*;

public class LC_107_BinaryTreeLevelOrderTraversal_II {

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

        // Testing the levelOrderBottom method
        List<List<Integer>> result = levelOrderBottom(root);

        // Printing the result
        System.out.println("Level Order Bottom-Up Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = q.poll();
                assert temp != null;
                currentLevel.add(temp.getData());
                if (temp.getLeft() != null)
                    q.offer(temp.getLeft());
                if (temp.getRight() != null)
                    q.offer(temp.getRight());
            }

            s.push(currentLevel);
        }

        while (!s.isEmpty()) {
            res.add(s.pop());
        }

        return res;
    }
}
