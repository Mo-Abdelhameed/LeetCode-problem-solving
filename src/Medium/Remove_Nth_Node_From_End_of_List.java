package Medium;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


Example 2:
Input: head = [1], n = 1
Output: []


Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
* */


import java.util.ArrayList;
import Medium.ListNode;
public class Remove_Nth_Node_From_End_of_List {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp);
            temp = temp.next;
        }

        int indexToRemove = list.size() - n;

        if(indexToRemove == 0){
            if(list.size() > 1)
                return head.next;
            else
                return null;
        }

        else if(indexToRemove == list.size() - 1)
            list.get(indexToRemove - 1).next = null;


        else
            list.get(indexToRemove - 1).next = list.get(indexToRemove + 1);

        list.get(indexToRemove).next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(new ListNode(1), 1));
    }

}


