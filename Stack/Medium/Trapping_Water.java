/*
Given an array of non-negative integers, height representing the elevation of ground. Calculate the amount of water that can be trapped after rain.
Example 1
Input: height= [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped
*/
---------------------------------------------------------------------------
//Brute Force:
    
import java.util.*;

class Solution {
    // Function to calculate trapped rainwater using brute force approach
    public int trap(int[] height) {
        int n = height.length;
        
        // Variable to store total trapped water
        int totalWater = 0;
        
        // Iterate over each bar in the elevation map
        for (int i = 0; i < n; i++) {
            // Initialize max heights to the left and right of current bar
            int maxLeft = 0;
            int maxRight = 0;
            
            // Find maximum height to the left of current bar
            for (int j = 0; j <= i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            
            // Find maximum height to the right of current bar
            for (int j = i; j < n; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            
            // Water trapped on current bar is min of maxLeft and maxRight minus current height
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }
        
        // Return total trapped water
        return totalWater;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input elevation map
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        // Create Solution object
        Solution sol = new Solution();
        
        // Calculate trapped water
        int result = sol.trap(height);
        
        // Print the result
        System.out.println("Trapped Rainwater: " + result);
    }
}
--------------------------------------------------------------------
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
