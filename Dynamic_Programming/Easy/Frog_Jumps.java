/*
Example 1: 30 10 60 10 60 50
  Think: Index Starts from index 0 to n-1. Let's say we are at index '2' at 60.
  The Energy required to reach 60 can be possible from prev index and prev prev index.
  Suppose 
  prev1= Energy difference between the prev1 and current, which is abs(arr[i]-arr[i-1])
  prev2= Energy difference between the prev2 and current, which is abs(arr[i]-arr[i-2])
   we need that along with the energies required to reach prev1 which is f(n-1) and for prev2 which is f(n-2)

   Now finally we need min from left or right
*/

//Recursion Code

public class FrogJump {

    static int frogJump(int ind, int[] heights) {

        if (ind == 0) {
            return 0;
        }

        int left = frogJump(ind - 1, heights)
                + Math.abs(heights[ind] - heights[ind - 1]);

        int right = Integer.MAX_VALUE;

        if (ind > 1) {
            right = frogJump(ind - 2, heights)
                    + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return Math.min(left, right);
    }

    public static void main(String[] args) {

        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;

        System.out.println(frogJump(n - 1, heights));
    }
}

// Memoization (Top-Down DP)

import java.util.Arrays;

public class FrogJump {

    static int frogJump(int ind, int[] heights, int[] dp) {

        if (ind == 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int left = frogJump(ind - 1, heights, dp)
                + Math.abs(heights[ind] - heights[ind - 1]);

        int right = Integer.MAX_VALUE;

        if (ind > 1) {
            right = frogJump(ind - 2, heights, dp)
                    + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(left, right);
    }

    public static void main(String[] args) {

        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(frogJump(n - 1, heights, dp));
    }
}
