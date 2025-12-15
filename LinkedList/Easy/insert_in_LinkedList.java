/*
Insert new element at begining and ending:
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode newNode = new ListNode(X);
        newNode.next = head;
        return newNode;
    }
}
---------------------------------------------------------------------------
class Solution {
    public ListNode insertAtLast(ListNode head, int X) {
        ListNode newNode = new ListNode(X);

        // Case 1: Empty list
        if (head == null) {
            return newNode;
        }
        // Case 2: Non-empty list
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
}


