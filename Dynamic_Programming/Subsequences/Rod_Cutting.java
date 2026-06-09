//Memoization

import java.util.*;
class Solution {
    // Function to compute max value by cutting rod using top-down DP
    public int rodCutting(int[] price, int n) {
        // Create DP table initialized to -1
        int[][] dp = new int[n][n + 1];
        // Fill dp with -1 to indicate uncomputed subproblems
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Start from last index (n - 1)
        return helper(n - 1, n, price, dp);
    }
    // Recursive helper function with memoization
    private int helper(int i, int length, int[] price, int[][] dp) {
        // Base case: only one rod piece of length 1
        if (i == 0) {
            return length * price[0];
        }
        // Return precomputed value
        if (dp[i][length] != -1) return dp[i][length];
        // Option 1: do not take current rod length
        int notTake = helper(i - 1, length, price, dp);
        // Option 2: take current rod length (if it fits)
        int take = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if (rodLength <= length) {
            take = price[i] + helper(i, length - rodLength, price, dp);
        }
        // Store max of both in dp
        return dp[i][length] = Math.max(take, notTake);
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Price list
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        // Total rod length
        int n = 8;

        // Output result
        int result = sol.rodCutting(price, n);
        System.out.println("The maximum obtainable value is: " + result);
    }
}

// Tabulation

import java.util.*;
class Solution {
    // Function to solve the rod cutting problem
    public int rodCutting(int[] price, int n) {
        // Initialize DP table with dimensions [n][n + 1]
        int[][] dp = new int[n][n + 1];
        for (int length = 0; length <= n; length++) {
            dp[0][length] = price[0] * length;
        }
        // Fill the DP table
        for (int ind = 1; ind < n; ++ind) { 
            for (int length = 1; length <= n; ++length) { 
                
                // Case when the piece is not taken
                int notTaken = dp[ind - 1][length];
                
                // Case when the piece is taken
                int taken = Integer.MIN_VALUE;
                
                /* Length of the rod piece 
                corresponding to the current index*/
                int rodLength = ind + 1;
                
                // Check if the piece can be taken
                if (rodLength <= length) {
                    taken = price[ind] + dp[ind][length - rodLength];
                }
                
                /* Update dp[ind][length] with the maximum of
                including or not including the current piece*/
                dp[ind][length] = Math.max(notTaken, taken);
            }
        }
        
        // Return the result
        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        int[] price = {2, 4, 6, 8};
        int n = price.length;
        // Create an instance of Solution class
        Solution sol = new Solution();
        // Print the result
        System.out.println("The Maximum value is " + sol.rodCutting(price, n));
    }
}
