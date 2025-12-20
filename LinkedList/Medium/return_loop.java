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
    public ListNode findStartingPoint(ListNode head) {
      
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp; // cycle found
            }
            map.put(temp, 1); // mark node as visited
            temp = temp.next;
        }

        return null; // no cycle
   
    }
}
