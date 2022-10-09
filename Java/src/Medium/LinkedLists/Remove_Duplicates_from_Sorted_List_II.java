package Medium.LinkedLists;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:

Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

public class Remove_Duplicates_from_Sorted_List_II {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode r = null;
        ListNode prev = head;
        ListNode current = prev.next;

        while(current != null && prev != null){
            if(prev.val == current.val){
                while (current.next != null && current.next.val == prev.val){
                    current = current.next;
                }
                if(prev == head)
                    head = current.next;
                else{
                    r.next = current.next;
                    prev = current.next;
                    if(prev == null)
                        break;
                    current = prev.next;
                    continue;
                }
            }
            r = prev;
            prev = current;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        deleteDuplicates(n1).printList();
    }
}
