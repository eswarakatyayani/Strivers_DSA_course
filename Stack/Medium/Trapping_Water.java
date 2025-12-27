/*
Given an array of non-negative integers, height representing the elevation of ground. Calculate the amount of water that can be trapped after rain.
Example 1
Input: height= [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped
*/
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;
                int minHeight = Math.min(height[left], height[i]) - height[bottom];
                water += width * minHeight;
            }
            stack.push(i);
        }
        return water;
    }
}
