// Memorization

import java.util.Arrays;
class Solution {
    int[][] dp;
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        dp = new int[n][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, K, arr);
    }
    private int solve(int i, int target, int[] arr) {
        if (target == 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][target] != -1)
            return dp[i][target];
        int notTake = solve(i - 1, target, arr);
        int take = 0;
        if (arr[i] <= target) {
            take = solve(i - 1, target - arr[i], arr);
        }
        return dp[i][target] = take + notTake;
    }
}

// Tabulation

class Solution {
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n + 1][K + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= K; sum++) {
                dp[i][sum] = dp[i - 1][sum];
                if (arr[i - 1] <= sum) {
                    dp[i][sum] += dp[i - 1][sum - arr[i - 1]];
                }
            }
        }
        return dp[n][K];
    }
}

//Space Optimised

class Solution {
    public int perfectSum(int[] arr, int K) {
        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int num : arr) {
            for (int sum = K; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }
        return dp[K];
    }
}
