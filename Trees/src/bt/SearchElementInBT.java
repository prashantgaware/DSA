package bt;

import java.util.Stack;

public class SearchElementInBT {
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
    private static boolean searchElementInBT(TreeNode root, int data) {
        if (root == null)
            return false;
        if (root.getData() == data)
            return true;

        return (searchElementInBT(root.left,data) || searchElementInBT(root.right,data));
    }

    /**
     * This method searches for an element in a binary tree using an iterative approach.
     * @param root - root node of the binary tree
     * @param data - data to search for
     * @return true if the element is found, false otherwise
     * Approach:
     * 1. Use a stack to keep track of nodes to visit.
     * 2. Start with the root node and push it onto the stack.
     * 3. While the stack is not empty, pop a node from the stack.
     * 4. If the popped node's data matches the search data, return true.
     * 5. If the popped node has a left child, push it onto the stack.
     * 6. If the popped node has a right child, push it onto the stack.
     * 7. If the stack is empty and no match was found, return false.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n) in the worst case, where n is the number of nodes in the tree (if the tree is skewed).
     */
    private static boolean searchElementIterative(TreeNode root, int data) {
        if (root == null)
            return false;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.pop();
            // check if the popped node's data matches the search data
            if (currNode.getData() == data)
                return true;
            // if popped node has children, push them onto the stack
            if (currNode.getLeft() != null)
                nodes.push(currNode.getLeft());
            if (currNode.getRight() != null)
                nodes.push(currNode.getRight());
        }
        return false;
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

        System.out.println(searchElementInBT(root, 11));
        System.out.println(searchElementIterative(root, 1));
    }
}
