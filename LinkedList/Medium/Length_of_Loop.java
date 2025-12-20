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
     public int findLengthOfLoop(ListNode head) {
     HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return c - map.get(temp); // correct loop length
            }
            map.put(temp, c);
            c++;
            temp = temp.next;
        }

        return 0; // no cycle
     }
 }
