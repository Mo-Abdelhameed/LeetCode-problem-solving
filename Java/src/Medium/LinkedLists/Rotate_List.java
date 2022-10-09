package Medium.LinkedLists;

/*
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

public class Rotate_List {

    public static int size(ListNode head){
        if(head == null) return 0;
        if(head.next == null) return 1;
        ListNode c = head;
        int size = 1;
        while(c.next != null){
            c = c.next;
            size++;
        }
        return size;
    }

    public static ListNode rotateRight(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        current.next = head;
        prev.next = null;
        head = current;
        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        k = k % size(head);
        while (k-- > 0)
            head = rotateRight(head);
        return head;
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

        rotateRight(n1, 2).printList();

    }

}
