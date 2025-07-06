class Solution {
    public int findLargest(int[] nums) {
        int largest = nums[0]; // assume first element is the largest

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i]; // update if current element is greater
            }
        }

        return largest;
    }
}
