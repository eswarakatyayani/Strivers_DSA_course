/*
Dynamic Programming can be described as storing answers to various sub-problems to be used later whenever required to solve the main problem.

The two common dynamic programming approaches are:

Memoization: Known as the “top-down” dynamic programming, usually the problem is solved in the direction of the main problem to the base cases.
Tabulation: Known as the “bottom-up '' dynamic programming, usually the problem is solved in the direction of solving the base cases to the main problem
*/

// METHOD 1: Memoisation

import java.util.*;

class Solution {
    // Function to calculate Fibonacci using memoization
    public int fib(int n, int[] dp) {
        // If base case return n
        if (n <= 1) return n;

        // If already computed, return stored value
        if (dp[n] != -1) return dp[n];

        // Otherwise compute and store
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        Solution sol = new Solution();
        System.out.println(sol.fib(n, dp));
    }
}

// Method 2: Tabulation

class Solution {
    // Function to calculate Fibonacci using tabulation
    public int fib(int n) {
        // If n is 0 or 1, return n
        if (n <= 1) return n;

        // Create dp array
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return final answer
        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 10;
        Solution sol = new Solution();
        System.out.println(sol.fib(n));
    }
}

//Method 3: Space Optimisation

class Solution {
    public int fib(int n) {
        // If n is 0 return 0
        if(n == 0) return 0;
        // If n is 1 return 1
        if(n == 1) return 1;

        // prev2 stores fib(n-2)
        int prev2 = 0;
        // prev stores fib(n-1)
        int prev = 1;
        // curr stores current fib
        int curr = 0;

        // Loop from 2 to n
        for(int i = 2; i <= n; i++) {
            // Calculate current fib
            curr = prev + prev2;
            // Update prev2
            prev2 = prev;
            // Update prev
            prev = curr;
        }
        // Return final answer
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 10;
        System.out.println(s.fib(n));
    }
}

