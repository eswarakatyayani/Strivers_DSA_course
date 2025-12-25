/*
Add two numbers in Linked List

Given two non-empty linked lists linkedList1 and linkedList2 which represent two non-negative integers.
The digits are stored in reverse order with each node storing one digit.
Add two numbers and return the sum as a linked list.
The sum Linked List will be in reverse order as well.
The Two given Linked Lists represent numbers without any leading zeros, except when the number is zero itself.

Example 1
Input: linkedList1 = [5, 4], linkedList2 = [4]
Output: [9, 4]
Explanation: linkedList1 = 45, linkedList2 = 4.
linkedList1 + linkedList2 = 45 + 4 = 49.

Example 2
Input: linkedList1 = [4, 5, 6], linkedList2 = [1, 2, 3]
Output: [5, 7, 9]
Explanation: linkedList1 = 654, linkedList2 = 321.
linkedList1 + linkedList2 = 654 + 321 = 975.
*/

/*
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
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {

        ListNode t1 = head1;
        ListNode t2 = head2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }

            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
