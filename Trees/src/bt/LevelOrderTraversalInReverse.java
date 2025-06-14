package bt;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalInReverse {
    public static void reverseLevelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> reverseStack = new Stack<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);

            reverseStack.add(temp);
        }

        while (!reverseStack.isEmpty()) {
            System.out.print(reverseStack.pop().data + " ");
        }
    }

    // this one uses a list to store the levels in reverse order
    // avoids using a stack and its second loop
    // instead uses a LinkedList to add levels at the front
    // using addFirst() method
    public static List<List<Integer>> reverseLevelOrderWithList(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = q.poll();
                currentLevel.add(temp.data);

                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            result.addFirst(currentLevel);
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

        System.out.println("Reverse Level Order Traversal:");
        reverseLevelOrder(root);
        System.out.println("\nReverse Level Order Traversal with List:");
    }
}
