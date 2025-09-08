package binary_search_tree;

public class InsertNodeInBST {
    public static BSTreeNode insertIntoBST(BSTreeNode root, int val) {
        if (root == null) {
            return new BSTreeNode(val);
        }
        if (val < root.data) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void inOrder(BSTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BSTreeNode root = new BSTreeNode(4);
        root.left = new BSTreeNode(2);
        root.right = new BSTreeNode(7);
        root.left.left = new BSTreeNode(1);
        root.left.right = new BSTreeNode(3);
        int val = 5;
        root = insertIntoBST(root, val);
        inOrder(root);
    }
}
