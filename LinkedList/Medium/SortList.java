/*
Sort a Linked List of 0's 1's and 2's

Given the head of a singly linked list consisting of only 0, 1 or 2.
Sort the given linked list and return the head of the modified list.
Do it in-place by changing the links between the nodes without creating new nodes.
Example 1
Input: linkedList = [1, 0, 2, 0 , 1]
Output: [0, 0, 1, 1, 2]
Explanation: The values after sorting are [0, 0, 1, 1, 2].
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
    public ListNode sortList(ListNode head) {

        int count0 = 0, count1 = 0, count2 = 0;
        ListNode temp = head;

        // Step 1: Count 0s, 1s, 2s
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        // Step 2: Overwrite values
        temp = head;

        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }

        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }

        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }
}
