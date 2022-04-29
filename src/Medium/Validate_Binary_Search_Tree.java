package Medium;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

Input: root = [2,1,3]
Output: true


Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

import Medium.TreeNode;

import java.util.ArrayList;

public class Validate_Binary_Search_Tree {
    static ArrayList<Integer> nodes = new ArrayList<>();
    public static void constructArray(TreeNode root) {
        if(root.right == null && root.left == null) {
            nodes.add(root.val);
            return;
        }
        if(root.left != null)
            constructArray(root.left);

        nodes.add(root.val);

        if(root.right != null)
            constructArray(root.right);
    }

    public static boolean isValidBST(TreeNode root) {
        nodes = new ArrayList<>();
        constructArray(root);
        for(int i = 0 ; i < nodes.size()-1 ; i++){
            if(nodes.get(i) >= nodes.get(i+1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        System.out.println(isValidBST(t));
    }


}
