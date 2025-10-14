package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_113_PathSum2 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        pathSumHelper(root, target, sum, temp);
        return result;
    }

    /**
     * The utility function to find the path sum.
     * @param root
     * @param target
     * @param sum
     * @param temp
     * Approach:
     *
     */
    public void pathSumHelper(TreeNode root, int target, int sum, List<Integer> temp) {
        if (root == null) {
            return;
        }

        sum = sum + root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(temp));
            }
        }

        pathSumHelper(root.left, target, sum, temp);
        pathSumHelper(root.right, target, sum, temp);

        // backtrack
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;

        LC_113_PathSum2 obj = new LC_113_PathSum2();
        List<List<Integer>> pathSum = obj.pathSum(root, targetSum);
        System.out.println(pathSum);
    }
}
