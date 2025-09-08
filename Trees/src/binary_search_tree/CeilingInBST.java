package binary_search_tree;

public class CeilingInBST {
    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(8);
        root.left = new BSTreeNode(4);
        root.right = new BSTreeNode(12);
        root.left.left = new BSTreeNode(2);
        root.left.right = new BSTreeNode(6);
        root.right.left = new BSTreeNode(10);
        root.right.right = new BSTreeNode(14);

        int key = 5;
        System.out.println("Ceiling of " + key + " is: " + findCeilingIterative(root, key));
        System.out.println("Ceiling of 4 is: " + findCeilingRecursive(root, 4));
    }

    /**
     *
     * @param root
     * @param key
     * @return
     * Approach:
     * 1. If the root is null, return -1.
     * 2. If the root's data is equal to the key, return the root's data.
     * 3. If the key is greater than the root's data, recursively call findCeiling on the right subtree.
     * 4. If the key is less than the root's data, recursively call findCeiling on the left subtree.
     * 5. If the result from the left subtree is -1, return the root's data. Otherwise, return the result from the left subtree.
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(h) due to recursion stack.
     */
    public static int findCeilingIterative(BSTreeNode root, int key) {
        int ceiling = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            } else if (key > root.data) {
                root = root.right;
            } else {
                ceiling = root.data;
                root = root.left;
            }
        }
        return ceiling;
    }

    /**
     *
     * @param root
     * @param key
     * @return
     * Approach:
     * 1. If the root is null, return -1.
     * 2. If the root's data is equal to the key, return the root's data.
     * 3. If the key is greater than the root's data, recursively call findCeiling on the right subtree.
     * 4. If the key is less than the root's data, recursively call findCeiling on the left subtree.
     * 5. If the result from the left subtree is -1, return the root's data. Otherwise, return the result from the left subtree.
     * Time Complexity: O(h) where h is the height of the tree.
     * Space Complexity: O(h) due to recursion stack.
     */
    public static int findCeilingRecursive(BSTreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return root.data;
        } else if (key > root.data) {
            return findCeilingRecursive(root.right, key);
        } else {
            int leftCeiling = findCeilingRecursive(root.left, key);
            return (leftCeiling == -1) ? root.data : leftCeiling;
        }
    }
}
