package bt;

public class LeastCommonAncestor {
    public static TreeNode lcaRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lcaRec(root.left, p, q);
        TreeNode right = lcaRec(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode lca = lcaRec(root, p, q);
        if (lca != null) {
            System.out.println("LCA of " + p.data + " and " + q.data + " is: " + lca.data);
        } else {
            System.out.println("LCA not found.");
        }
    }
}
