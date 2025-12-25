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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashMap<ListNode, Boolean> map = new HashMap<>();

        // Step 1: Store all nodes of list A
        ListNode temp = headA;
        while (temp != null) {
            map.put(temp, true);
            temp = temp.next;
        }

        // Step 2: Traverse list B and check
        temp = headB;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp; // intersection node
            }
            temp = temp.next;
        }

        return null; // no intersection
    }
}

