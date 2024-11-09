package com.cf.trees.binary;

// TreeNode class
class TreeNode {
    Object data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// BSTImplementation class
public class BSTImplementation {
    // root node of the binary tree
    TreeNode root = null;

    /**
     * This method inserts the data into the binary tree.
     * @param data - data to be inserted
     *             Explanation:
     *             1. If root is null, then assign the new node to root.
     *             2. If root is not null, then traverse the tree to find the correct position to insert the new node.
     *             3. If data is less than current node data, then move to left node.
     *             4. If data is greater than current node data, then move to right node.
     *             5. If left node is null, then assign the new node to left node.
     *             6. If right node is null, then assign the new node to right node.
     *             7. Repeat the steps 3 to 6 until we find the correct position to insert the new node.
     *             Time Complexity: O(log n) - Best case and Average case, O(n) - Worst case
     */
    public void insert(Object data) {
        TreeNode treeNode = new TreeNode(data);
        if (root == null) {
            root = treeNode; // if root is null, then assign the new node to root
        } else {
            TreeNode current = root;    // current node
            TreeNode parent;    // parent node
            while (true) {
                parent = current;   // assign current node to parent node
                if ((int) data < (int) current.data) {  // if data is less than current node data
                    current = current.left; // move to left node
                    if (current == null) {
                        parent.left = treeNode; // if left node is null, then assign the new node to left node
                        return;
                    }
                } else {    // if data is greater than current node data
                    current = current.right;    // move to right node
                    if (current == null) {  // if right node is null, then assign the new node to right node
                        parent.right = treeNode;    // assign the new node to right node
                        return;
                    }
                }
            }
        }
    }

    /**
     * This method searches the data in the binary tree.
     * @param data - data to be searched
     * @return searched data
     *        Explanation:
     *        1. If root is null, then return null.
     *        2. If root is not null, then traverse the tree to find the data.
     *        3. If data is equal to current node data, then return the data.
     *        4. If data is less than current node data, then move to left node.
     *        5. If data is greater than current node data, then move to right node.
     *        6. Repeat the steps 3 to 5 until we find the data.
     *        Time Complexity: O(log n) - Best case and Average case, O(n) - Worst case
     */
    public Object search(Object data) {
        TreeNode current = root;
        while (current != null) {
            if ((int) data == (int) current.data) {
                return current.data;
            } else if ((int) data < (int) current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    /**
     * This method deletes the data from the binary tree.
     * @param data - data to be deleted
     *             Explanation:
     *             1. If root is null, then return.
     *             2. If root is not null, then traverse the tree to find the data.
     *             3. If data is equal to current node data, then break the loop.
     *             4. If data is less than current node data, then move to left node.
     *             5. If data is greater than current node data, then move to right node.
     *             6. Repeat the steps 3 to 5 until we find the data.
     *             7. If current node is null, then return.
     *             8. If the node to be deleted has no children, then delete the node.
     *             9. If the node to be deleted has only left child, then delete the node.
     *             10. If the node to be deleted has only right child, then delete the node.
     *             11. If the node to be deleted has both left and right children, then delete the node.
     *             Time Complexity: O(log n) - Best case and Average case, O(n) - Worst case
     *             Space Complexity: O(1)
     *             Note: In the worst case, the height of the binary tree is equal to the number of nodes in the tree.
     *             So, the time complexity is O(n).
     *             In the best case and average case, the height of the binary tree is log n.
     *             So, the time complexity is O(log n).
     */
    public void delete(Object data) {
        TreeNode current = root;
        TreeNode parent = null;
        boolean isLeftChild = false;
        while (current != null) {
            if ((int) data == (int) current.data) {
                break;
            } else {
                parent = current;
                if ((int) data < (int) current.data) {
                    current = current.left;
                    isLeftChild = true;
                } else {
                    current = current.right;
                    isLeftChild = false;
                }
            }
        }

        if (current == null) {
            return;
        }

        // Case 1: If the node to be deleted has no children
        // If the node to be deleted is root node, then assign null to root.
        // If the node to be deleted is left child, then assign null to left child of parent.
        // If the node to be deleted is right child, then assign null to right child of parent.
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        // Case 2: If the node to be deleted has only left child
        // If the node to be deleted is root node, then assign left child to root.
        // If the node to be deleted is left child, then assign left child to left child of parent.
        // If the node to be deleted is right child, then assign left child to right child of parent.
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        }
        // Case 3: If the node to be deleted has only right child
        // If the node to be deleted is root node, then assign right child to root.
        // If the node to be deleted is left child, then assign right child to left child of parent.
        // If the node to be deleted is right child, then assign right child to right child of parent.
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        // Case 4: If the node to be deleted has both left and right children
        // If the node to be deleted is root node, then assign successor to root.
        // If the node to be deleted is left child, then assign successor to left child of parent.
        // If the node to be deleted is right child, then assign successor to right child of parent.
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else {
                if (isLeftChild) {
                    parent.left = successor;
                } else {
                    assert parent != null;
                    parent.right = successor;
                }
            }
            successor.left = current.left;
        }
    }

    /**
     * This method returns the successor of the node to be deleted.
     * @param current - node to be deleted
     * @return successor of the node to be deleted
     */
    private TreeNode getSuccessor(TreeNode current) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode temp = current.right;
        while (temp != null) {
            successorParent = successor;
            successor = temp;
            temp = temp.left;
        }

        if (successor != current.right) {
            successorParent.left = successor.right;
            successor.right = current.right;
        }

        return successor;
    }

    /**
     * This method prints the preorder traversal of the binary tree.
     * @param root - root node of the binary tree
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * This method prints the preorder traversal of the binary tree.
     * @param root - root node of the binary tree
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * This method prints the preorder traversal of the binary tree.
     * @param root - root node of the binary tree
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        BSTImplementation bst = new BSTImplementation();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal of binary tree is ");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Preorder traversal of binary tree is ");
        bst.preOrder(bst.root);
        System.out.println();

        System.out.println("Postorder traversal of binary tree is ");
        bst.postOrder(bst.root);
        System.out.println();

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));

        bst.delete(20);
    }
}
