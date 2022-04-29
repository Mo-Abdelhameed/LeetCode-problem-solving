package Medium;

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


