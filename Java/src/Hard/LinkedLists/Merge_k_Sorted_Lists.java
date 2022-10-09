package Hard.LinkedLists;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6


Example 2:

Input: lists = []
Output: []


Example 3:

Input: lists = [[]]
Output: []

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/

import Medium.LinkedLists.ListNode;
import java.util.PriorityQueue;
public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ListNode list : lists){
            while(list != null){
                queue.add(list.val);
                list = list.next;
            }
        }
        if(queue.isEmpty()) return null;

        ListNode result = new ListNode();
        ListNode temp = result;
        while(!queue.isEmpty()){
            temp.val = queue.poll();
            if(!queue.isEmpty()){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
