package Medium.Trees;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
*/

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {
    public static void connectHelper(Node child, Node parent, Node uncle, boolean left){
        if(child == null) return;

        if(left)
            child.next = parent.right;
        else if(uncle != null)
            child.next = uncle.left;

        connectHelper(child.left, child, parent.right, true);
        connectHelper(child.right, child, parent.right, false);
    }

    public static Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        connectHelper(root.left, root, null, true);
        connectHelper(root.right, root, null, false);
        return root;
    }

    public static Node connectBFS(Node root){
        if(root == null || root.left == null) return root;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Queue<Node> temp = q1;
        q1.add(root);

        while(!q1.isEmpty()){
            Node n = q1.poll();
            if(!q1.isEmpty())
                q1.peek().next = n;
            if(n.right != null) {
                q2.add(n.right);
                q2.add(n.left);
            }
            if(q1.isEmpty()){
                temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node left_left = new Node(4);
        Node left_right = new Node(5);
        Node right_left = new Node(6);
        Node right_right = new Node(7);

        root.left = left;
        root.right = right;
        root.left.left = left_left;
        root.left.right = left_right;
        root.right.left = right_left;
        root.right.right = right_right;
        Node connected = connect(root);
        System.out.println(connected.left.next.val);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}