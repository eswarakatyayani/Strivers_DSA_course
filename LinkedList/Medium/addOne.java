/*
Add one to a number represented by LL
Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.
The number will contain no leading zeroes except when the value represented is zero itself.

Example 1
Input: head -> 1 -> 2 -> 3
Output: head -> 1 -> 2 -> 4
Explanation: The number represented by the linked list = 123.

123 + 1 = 124.
*/
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

    public ListNode addOne(ListNode head) {
        // Step 1: reverse list
        head = reverse(head);

        ListNode curr = head;
        int carry = 1;  // because we add ONE

        // Step 2: add carry
        while (curr != null && carry > 0) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
            }

            curr = curr.next;
        }

        // Step 3: reverse back
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
