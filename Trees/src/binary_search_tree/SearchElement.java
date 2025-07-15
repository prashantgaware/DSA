package binary_search_tree;

public class SearchElement {
    /**
     *
     * @param root
     * @param data
     * @return
     * Approach:
     * 1. Start at the root node.
     * 2. If the current node is null, return null indicating the value was not found.
     * 3. If the current node's data matches the search value, return the current node.
     * 4. If the search value is less than the current node's data, recursively search in the left subtree.
     * 5. If the search value is greater than the current node's data, recursively search in the right subtree.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(h) for the recursive stack space.
     */
    public static BSTreeNode searchElement(BSTreeNode root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            return searchElement(root.left, data);
        } else if (data > root.data) {
            return searchElement(root.right, data);
        } else
            return root;
    }

    /**
     *
     * @param root
     * @param data
     * @return
     * Approach:
     * 1. Start at the root node.
     * 2. While the current node is not null:
     * 3. If the current node's data matches the search value, return the current node.
     * 4. If the search value is less than the current node's data, move to the left child.
     * 5. If the search value is greater than the current node's data, move to the right child.
     * 6. If the current node becomes null, return null indicating the value was not found.
     * Time Complexity: O(h), where h is the height of the tree.
     * Space Complexity: O(1) for the iterative approach.
     */
    private static BSTreeNode searchElementWithoutRec(BSTreeNode root, int data) {
        if (root == null)
            return null;

        while (root != null) {
            if (data == root.data)
                return root;
            else if (data < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(10);
        root.left = new BSTreeNode(5);
        root.right = new BSTreeNode(15);
        root.left.left = new BSTreeNode(3);
        root.left.right = new BSTreeNode(7);
        root.right.right = new BSTreeNode(20);

        int searchValue = 7;
        BSTreeNode result = searchElement(root, searchValue);
        if (result != null) {
            System.out.println("Element " + searchValue + " found in the tree.");
        } else {
            System.out.println("Element " + searchValue + " not found in the tree.");
        }
    }
}
