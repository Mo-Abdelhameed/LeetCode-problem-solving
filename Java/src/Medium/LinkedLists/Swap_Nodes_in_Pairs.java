package Medium.LinkedLists;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]


Example 2:

Input: head = []
Output: []


Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/

public class Swap_Nodes_in_Pairs {
    public static  ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode t1 = head;
        ListNode result = head.next;
        ListNode temp = null;

        while(t1 != null && t1.next != null){
            ListNode t2 = t1.next;
            t1.next = t2.next;
            t2.next = t1;
            if(temp != null)
                temp.next = t2;
            temp = t1;
            t1 = t1.next;
        }
        return result;
    }
}
