package Medium.Trees;
/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]


Example 3:

Input: root = []
Output: []
 */
import java.util.*;

public class Binary_Tree_Level_Order_Traversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> activeQueue = new LinkedList<>();
        Queue<TreeNode> sleepingQueue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        activeQueue.add(root);
        ArrayList<Integer> levelNodes = new ArrayList<>();
        while (!activeQueue.isEmpty()){
            TreeNode node = activeQueue.poll();
            if(node != null) {
                levelNodes.add(node.val);
                sleepingQueue.add(node.left);
                sleepingQueue.add(node.right);
            }

            if(activeQueue.isEmpty()){
                temp = activeQueue;
                activeQueue = sleepingQueue;
                sleepingQueue = temp;
                if(levelNodes.size() > 0)
                    result.add((ArrayList)levelNodes.clone());
                levelNodes.clear();
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}