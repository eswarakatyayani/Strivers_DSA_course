/*
//NOTE: Consider this problems as Longest substring with consective 1's with atmost K zeros

Max Consecutive Ones III
Given a binary array nums and an integer k, flip at most k 0's.
Return the maximum number of consecutive 1's after performing the flipping operation.

Example 1
Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3
Output : 10
Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3, 4, 5 (0 base indexing).
The array after flipping becomes [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0].
The number of consecutive 1's is 10.
*/

import java.util.*;

class Solution {
    // Function to find the longest subarray with at most k zero flips
    public int longestOnes(int[] nums, int k) {

        // Left pointer of the sliding window
        int left = 0;

        // Counter for zeros in the window
        int zerocount = 0;

        // Variable to store maximum window length
        int maxlen = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // If current element is zero, increment zerocount
            if (nums[right] == 0) {
                zerocount++;
            }

            // If zerocount exceeds k, move left and adjust zerocount
            if (zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                // Shrink window from left
                left++; 
            }

            // Update maximum window size
            maxlen = Math.max(maxlen, right - left + 1);
        }

        // Return the final result
        return maxlen;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        // Output the result
        System.out.println(sol.longestOnes(nums, k));
    }
}
