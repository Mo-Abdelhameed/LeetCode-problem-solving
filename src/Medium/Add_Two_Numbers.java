package Medium;




/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class Add_Two_Numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode temp = result;
        int sum = 0, carry = 0;
        while(l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) > 9 ? 1 : 0;
            temp.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null & l2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        ListNode remainder = null;
        if(l1 != null)
         remainder = l1;

        else if (l2 != null)
            remainder = l2;

        if (remainder != null) {
            temp.next = new ListNode();
            temp = temp.next;
        }

        while(remainder != null){
            sum = (remainder.val + carry) % 10;
            carry = (remainder.val + carry) > 9 ? 1 : 0;
            temp.val = sum;
            remainder = remainder.next;
            if(remainder != null){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        if(carry == 1)
            temp.next = new ListNode(1);

        return result;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        ListNode s1 = new ListNode(9);




        System.out.println(addTwoNumbers(s1,l1));

    }



}





class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        String res = "";
        ListNode temp = this;
        while(temp != null){
            res += temp.val;
            temp = temp.next;
        }
        return res;
    }
}