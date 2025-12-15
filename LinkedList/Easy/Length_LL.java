class Solution {
    public int getLength(ListNode head) {
        // Your code goes here
        int c=1;
        if(head==null)
        return 0;
        while(head.next!=null)
        {
            head=head.next;
            c++;

        }
        return c;
    }
}
