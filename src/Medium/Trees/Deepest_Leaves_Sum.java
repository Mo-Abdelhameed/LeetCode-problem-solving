package Medium.Trees;
/*
Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
*/
public class Deepest_Leaves_Sum {
    static int sum = 0;
    public static int deepestLeavesSum(TreeNode root) {
        sum = 0;
        int levels = levels(root);
        helper(root, levels);
        return sum;
    }

    public static void helper(TreeNode root, int levels){
        if(root == null) return;
        if(levels == 1)
            sum += root.val;
        helper(root.left, levels-1);
        helper(root.right, levels-1);
    }

    public static int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
}
