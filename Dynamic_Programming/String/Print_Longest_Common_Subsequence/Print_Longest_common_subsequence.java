// Print the longest common subsequence

/*
To find the Longest Common Subsequence of two strings, we need to have the 2D DP table where each cell at position (i, j) stores the length of the LCS between the prefixes of the two strings up to indices i and j.
To make this 2D DP table we can follow any of the approach that we learned while finding the length of the Longest Common Subsequence.
Once the DP table is completely filled, start from the bottom-right corner (n,m) of the table, where n and m are the lengths of the two strings.
Compare the characters of the two strings at positions i-1 and j-1:
If they match, this character is part of the LCS. Add this character to the LCS string (building it backwards) and move diagonally up-left i-1, j-1) in the DP table.
If they do not match, move in the direction of the larger DP value between dp[i-1][j] and dp[i][j-1]. This step helps trace the path of the optimal solution:
If dp[i-1][j] is greater than dp[i][j-1], move up to (i-1, j). Otherwise, move left to i, j-1.
Continue this process until you reach the top row or leftmost column (i == 0 or j==0).
Reverse the collected characters since the reconstruction starts from the end.
The reversed string is the actual LCS between the two strings.
*/

class Solution {
    // Function to return the LCS string of text1 and text2
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create DP table to store lengths of LCS for all substrings
        int[][] dp = new int[n + 1][m + 1];

        // Fill dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match: increase length by 1
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Characters don't match: take max of left and top
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // Reconstruct LCS string from dp table
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        // Traverse dp table from bottom-right to top-left
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                // Characters match, add to result and move diagonally
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move up if top cell has greater value
                i--;
            } else {
                // Move left otherwise
                j--;
            }
        }
        // Reverse string since it was built backwards
        return lcs.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        Solution sol = new Solution();
        System.out.println("LCS: " + sol.longestCommonSubsequence(s1, s2));
    }
}
