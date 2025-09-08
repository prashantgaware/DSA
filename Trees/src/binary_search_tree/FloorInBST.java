package binary_search_tree;

/**
 * Find the floor of a given key in a Binary Search Tree (BST).
 * The floor of a key is the largest value in the BST that is less than or equal to the key.
 * If no such value exists, return -1.
 * Example:
 * Input: root = [8,4,12,2,6,10,14], key = 5
 * Output: 4
 * Explanation: The largest value in the BST that is less than or equal to 5 is 4.
 */

public class FloorInBST {
    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(8);
        root.left = new BSTreeNode(4);
        root.right = new BSTreeNode(12);
        root.left.left = new BSTreeNode(2);
        root.left.right = new BSTreeNode(6);
        root.right.left = new BSTreeNode(10);
        root.right.right = new BSTreeNode(14);
        System.out.println(floorInBST(root, 5));
    }

    public static int floorInBST(BSTreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key)
                return root.data;
            else if (key < root.data) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
