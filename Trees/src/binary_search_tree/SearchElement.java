package binary_search_tree;

public class SearchElement {
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
