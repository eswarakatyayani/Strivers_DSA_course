// Its mentioned in the question that there is an infinite amount of supply is assumed.
import java.util.*;

class Solution {
    // Utility function to solve unbounded knapsack problem
    public int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: only first item available
        if (ind == 0) {
            return (W / wt[0]) * val[0];
        }

        // If already computed, return stored value
        if (dp[ind][W] != -1) return dp[ind][W];

        // Option 1: Do not take current item
        int notTaken = knapsackUtil(wt, val, ind - 1, W, dp);

        // Option 2: Take current item (if it fits)
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind, W - wt[ind], dp);
        }

        // Store and return the best option
        return dp[ind][W] = Math.max(notTaken, taken);
    }

    // Main function to initialize DP and call utility
    public int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return knapsackUtil(wt, val, n - 1, W, dp);
    }
}

// Separate driver class
public class Main {
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;

        Solution obj = new Solution();
        System.out.println("The Maximum value of items the thief can steal is " 
                           + obj.unboundedKnapsack(n, W, val, wt));
    }
}
