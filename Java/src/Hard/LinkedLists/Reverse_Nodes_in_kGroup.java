package Hard.LinkedLists;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]


Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
*/

public class Reverse_Nodes_in_kGroup {

    public static ListNode reverseList(ListNode head, int start, int end){
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode startNode = head;
        ListNode endNode = head;
        int startIndex = 0;
        int endIndex = 0;
        boolean remaining = true;
        ListNode result = head;
        while (endNode != null){
            for(int i = 0 ; i < k ; i++){
                if(endNode != null) {
                    endNode = endNode.next;
                    endIndex++;
                }
                else
                    remaining = false;
            }
            if(!remaining)
                break;
            result = reverseList(result, startIndex, endIndex);
            startIndex = endIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        reverseKGroup(n1, 2).printList();
    }
}
