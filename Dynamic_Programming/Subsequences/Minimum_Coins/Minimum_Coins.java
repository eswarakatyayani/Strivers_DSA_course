// Memoization

class Solution {
    int INF = (int)1e9;
    int solve(int ind, int target, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (target % coins[0] == 0)
                return target / coins[0];
            return INF;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notTake = solve(ind - 1, target, coins, dp);
        int take = INF;
        if (coins[ind] <= target) {
            take = 1 + solve(ind, target - coins[ind], coins, dp);
        }

        return dp[ind][target] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);
        int ans = solve(n - 1, amount, coins, dp);
        return ans >= INF ? -1 : ans;
    }  
}

// Tabulation

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int)1e9;
        int[][] dp = new int[n][amount + 1];
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = t / coins[0];
            else
                dp[0][t] = INF;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = INF;
                if (coins[ind] <= target) {
                    take = 1 + dp[ind][target - coins[ind]];
                }
                dp[ind][target] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans >= INF ? -1 : ans;
    }
}
