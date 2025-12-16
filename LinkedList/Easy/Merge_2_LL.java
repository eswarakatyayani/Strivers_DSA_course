/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        if(temp1==null)
        {
            return list2;
        }
        while(temp1.next!=null)
        {
            temp1=temp1.next;
        }
        temp1.next=list2;
      return list1;
        
    }
}

/*
list1 = [1,2,4]
list2 = [1,3,4]
Output= [1,2,4,1,3,4]
*/
