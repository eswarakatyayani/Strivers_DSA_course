class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxc=0, count=0;
        for(int i=0;i<nums.length;i++)
        { 
            if(nums[i]==1)
            {
                 count++;
            }
            else
            {
                count=0;
            }
         if(count>maxc)
          maxc=count;
        }
        return maxc;
    }
}
