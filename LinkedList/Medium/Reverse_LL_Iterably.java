/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=new ListNode();
        ListNode temp=new ListNode();
        ListNode front=new ListNode();
        pre=null;
        temp=head;
        while(temp!=null)
        {
            front=temp.next;
            temp.next=pre;
            pre=temp;
            temp=front;
        }
        return pre;
    }
}
