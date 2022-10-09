package Medium.LinkedLists;

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]


Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/

public class Partition_List {

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode prev = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode prevMover = prev;
        ListNode afterMover = after;

        while (current != null){
            if(current.val < x){
                prevMover.next = current;
                prevMover = current;
            }
            else{
                afterMover.next = current;
                afterMover = current;
            }
            current = current.next;
        }
        afterMover.next = null;
        prevMover.next = after.next;
        return prev.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);
        ListNode n8 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        partition(n1, 3).printList();
    }
}
