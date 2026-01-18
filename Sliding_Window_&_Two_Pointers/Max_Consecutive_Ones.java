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

class Solution {
    public int longestOnes(int[] nums, int k) {
        int lengthMax=0;
        int zero=0;
        int l=0;
       for(int r=0;r<nums.length;r++)
       {
        if(nums[r]==0)
        {
          zero++;
        }
        if( zero <= k)
        {
         lengthMax=Math.max(lengthMax, r-l+1);
        }
        while(zero>k)
        {
            if(nums[l]==0){
            zero--;
            l++;
            break;
            }
            else
            l++ ;
        }
       }
       return lengthMax;  
    }
}
