// String problem for Longest common subsequence

// Memoization
import java.util.*;

// Class containing the LCS logic
class Solution {
    /* Function to find the length of the
       Longest Common Subsequence (LCS) */
    private int func(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // Base case: if either string is exhausted
        if (ind1 < 0 || ind2 < 0)
            return 0;

        // If result already calculated, return it
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If characters match, increment LCS length
        if (s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + func(s1, s2, ind1 - 1, ind2 - 1, dp);
        else
            // Otherwise, skip one char from either string and take max
            return dp[ind1][ind2] =
                Math.max(func(s1, s2, ind1, ind2 - 1, dp),
                         func(s1, s2, ind1 - 1, ind2, dp));
    }

    /* Public function to calculate the LCS length */
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // DP table initialized to -1
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Compute result
        return func(str1, str2, n - 1, m - 1, dp);
    }
}

// Separate Main class for running the code
class Main {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        
        // Create Solution instance
        Solution sol = new Solution();
        
        // Call LCS function and print result
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}


// Tabulation
import java.util.*;

// Class containing LCS logic
class Solution {
    /* Function to calculate the length
       of the Longest Common Subsequence */
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        // DP table of size (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];
        
        // Initialize base cases (first row and column to 0)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the DP table
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                // Characters match → take diagonal + 1
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1]; 
                // Characters don't match → take max from left or above
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]); 
            }
        }
        
        // Result is in dp[n][m]
        return dp[n][m]; 
    }
}

// Separate Main class for execution
class Main {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        
        // Create Solution instance
        Solution sol = new Solution();
        
        // Output the LCS length
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}
