package binary_search_tree;

public class LeastCommonAncestorInBST {
    /**
     * Find the lowest common ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     * @param root the root of the BST
     * @param p the first node
     * @param q the second node
     * @return the LCA of nodes p and q
     * Approach:
     * 1. Start from the root of the BST.
     * 2. If both p and q are greater than the current node, move to the right child.
     * 3. If both p and q are less than the current node, move to the left child.
     * 4. If one of p or q is one side and the other is on the other side, the current node is the LCA.
     * 5. Return the current node as the LCA.
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(1) since we are using an iterative approach.
     * Dry Run:
     * Consider the following BST:
     *         6
     *        / \
     *       2   8
     *      / \ / \
     *     0  4 7  9
     *       / \
     *      3   5
     *    Let's find the LCA of nodes 2 and 4.
     *    1. Start at root (6). Both 2 and 4 are less than 6, move to left child (2).
     *    2. Now at node (2). 2 is equal to p, and 4 is greater than 2, so we have found the LCA.
     *    3. Return node (2) as the LCA.
     *   The function returns the LCA of nodes 2 and 4, which is node 2.
     */
    public static BSTreeNode lca(BSTreeNode root, BSTreeNode p, BSTreeNode q) {
        if (root == null) {
            return null;
        }

        BSTreeNode current = root;
        while (current != null) {
            if (p.data > current.data && q.data > current.data) {
                current = current.right;
            } else if (p.data < current.data && q.data < current.data) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(6);
        root.left = new BSTreeNode(2);
        root.right = new BSTreeNode(8);
        root.left.left = new BSTreeNode(0);
        root.left.right = new BSTreeNode(4);
        root.left.right.left = new BSTreeNode(3);
        root.left.right.right = new BSTreeNode(5);
        root.right.left = new BSTreeNode(7);
        root.right.right = new BSTreeNode(9);

        BSTreeNode p = root.left; // Node with value 2
        BSTreeNode q = root.left.right; // Node with value 4

        BSTreeNode lcaNode = lca(root, p, q);
        if (lcaNode != null) {
            System.out.println("LCA of " + p.data + " and " + q.data + " is: " + lcaNode.data);
        } else {
            System.out.println("LCA not found.");
        }
    }
}
