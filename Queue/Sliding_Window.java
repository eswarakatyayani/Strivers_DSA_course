/*
Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
Example 1:
Input: arr = [4, 0, -1, 3, 5, 3, 6, 8], k = 3
Output: [4, 3, 5, 5, 6, 8]

Explanation: 
Window position          Max
------------------------     -----

[4 0 -1] 3 5 3 6 8      4

 4 [0 -1 3] 5 3 6 8      3

 4 0 [-1 3 5] 3 6 8      5

 4 0 -1 [3 5 3] 6 8      5

 4 0 -1 3 [5 3 6] 8      6

 4 0 -1 3 5 [3 6 8]     8

For each window of size k=3, we find the maximum element in the window and add it to our output array.

*/
import java.util.*;

class Solution {
    // Function to return the max of each sliding window of size k
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // Deque to store indices of useful elements
        Deque<Integer> dq = new LinkedList<>();

        // List to store result
        List<Integer> result = new ArrayList<>();

        // Loop through each element
        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller values from the back of deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Add to result once the first window is formed
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }

        // Return result list
        return result;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        List<Integer> ans = obj.maxSlidingWindow(arr, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}

/*
dq.offerLast();   // add at rear
dq.offerFirst();  // add at front
dq.pollFirst();   // remove from front
dq.pollLast();    // remove from rear
dq.peekFirst();   // look at front
dq.peekLast();    // look at rear
*/
