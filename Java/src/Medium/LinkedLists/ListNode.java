package Medium.LinkedLists;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        String res = "";
        ListNode temp = this;
        while(temp != null){
            res += temp.val;
            temp = temp.next;
        }
        return res;
    }

    public void printList(){
        ListNode t = this;
        while (t != null){
            System.out.print(t.val + " ");
            t = t.next;
        }
    }
}
