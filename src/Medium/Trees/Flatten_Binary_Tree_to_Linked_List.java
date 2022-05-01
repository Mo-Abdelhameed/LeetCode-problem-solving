package Medium.Trees;

/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [0]
Output: [0]

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

public class Flatten_Binary_Tree_to_Linked_List {

    public static TreeNode flattenSmallTree(TreeNode root){
        if(root.left != null && root.right != null){
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.left = null;
            root.right = left;
            root.right.right = right;
            return root;
        }

        if(root.left != null){
            root.right = root.left;
            root.left = null;
            return root;
        }

        if(root.right != null)
            return root;

        return root;
    }

    public static boolean isSmallTree(TreeNode root){
        if(root != null && root.left != null && (root.left.left != null || root.left.right != null))
            return false;

        if(root != null && root.right != null && (root.right.left != null || root.right.right != null))
            return false;

        return true;
    }

    public static TreeNode flattenHelper(TreeNode root) {

        if(root == null)
            return null;
        if(isSmallTree(root)){
            return flattenSmallTree(root);
        }
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        root.right = left;
        TreeNode c = root;
        while (c.right != null)
            c = c.right;
        c.right = right;
        root.left = null;
        return root;
    }

    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode left_left = new TreeNode(3);
        TreeNode left_right = new TreeNode(4);
        TreeNode left_left_left = new TreeNode(5);
        root.left = left;
        root.left.left = left_left;
        root.left.left.left = left_left_left;
        root.left.right = left_right;
        flatten(root);
        TreeNode c = root;
        while (c != null){
            System.out.println(c.val);
            c = c.right;
        }
    }
}
