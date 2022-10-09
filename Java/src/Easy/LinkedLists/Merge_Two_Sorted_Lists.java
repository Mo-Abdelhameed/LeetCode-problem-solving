package Easy.LinkedLists;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]


Example 2:
Input: list1 = [], list2 = []
Output: []


Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

import Medium.LinkedLists.ListNode;
public class Merge_Two_Sorted_Lists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        ListNode result = new ListNode();
        ListNode temp = result;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.val = list1.val;
                list1 = list1.next;
            }
            else{
                temp.val = list2.val;
                list2 = list2.next;
            }
            if(list1 != null || list2 != null){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        ListNode remainder = list1 != null ? list1 : (list2 != null) ? list2 : null;

        while(remainder != null){
            temp.val = remainder.val;
            remainder = remainder.next;
            if(remainder != null){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return result;
    }
}
