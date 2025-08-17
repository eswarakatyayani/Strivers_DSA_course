/*
Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.
Examples:
Input: nums = [0, 1, 4, 0, 5, 2]
Output: [1, 4, 5, 2, 0, 0]
*/

//two pointers method

class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=0;i<nums.length;i++)
        {
          if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
        
          }
            
        }
    }
}
