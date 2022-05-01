package Medium.LinkedLists;
/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
*/

public class Reverse_Linked_List_II {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int start = left-1, end = right;
        ListNode current = head;
        int i = start;
        ListNode startNode = null;
        while (i-- > 0){
            startNode = current;
            current = current.next;
        }
        ListNode endNode = null;
        ListNode r = null;
        i = start;
        while(i < end){
            ListNode prev = current;
            current = current.next;
            prev.next = r;
            r = prev;
            i++;
            endNode = current;
        }
        if(startNode != null)
            startNode.next = r;
        else
            head = r;

        while (r.next != null)
            r = r.next;

        r.next = endNode;
        return head;
    }
}
