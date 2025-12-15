/*
Defination of linked list
class ListNode {
    int data;
    ListNode next;

    ListNode() {
        this.data = 0;
        this.next = null;
    }

    ListNode(int x) {
        this.data = x;
        this.next = null;
    }

    ListNode(int x, ListNode next) {
        this.data = x;
        this.next = next;
    }
}
*/
class Solution {
    public ListNode deleteHead(ListNode head) {
    if (head == null) {
            return null; // empty list
        }
        head=head.next;
        return head;
    }
}
-------------------------------------------------
// NOTE: We cannot assign temp to NULL. “Because it only clears the local reference (making temp as null). 
//But still the main Head Linked list structure is controlled by next links, not variables.”
// To delete a node, break the arrow. So link second last node to null. (temp.next=null);
class Solution {
    public ListNode deleteLast(ListNode head) {

        // Case 1: Empty list
        if (head == null) {
            return null;
        }

        // Case 2: Only one node
        if (head.next == null) {
            return null;
        }

        // Case 3: More than one node
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // temp is second-last node
        temp.next = null;

        return head;
    }
}
