// String problem for Longest common subsequence

// Memoization
import java.util.Arrays;
public class Solution {
    private static int f(int i, int j, String s, String t, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + f(i - 1, j - 1, s, t, dp);
        }
        return dp[i][j] = Math.max(
                f(i - 1, j, s, t, dp),
                f(i, j - 1, s, t, dp)
        );
    }
    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, s, t, dp);
    }
    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        System.out.println(lcs(s, t));   // Output: 3
    }
}
/*
Time Complexity
O(N × M)
Space Complexity
O(N × M) for the memoization table
O(N + M) recursion stack space
*/

// Tabulation
public static int lcsTabulation(String s, String t) {
    int n = s.length();
    int m = t.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[n][m];
}
