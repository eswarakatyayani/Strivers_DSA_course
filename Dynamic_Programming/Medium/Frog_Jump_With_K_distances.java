// Frog jump with K distances

// Recursion + Memoization (Top Down)

import java.util.Arrays;

public class Solution {

    private int solve(int index, int[] heights, int k, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int jump = 1; jump <= k; jump++) {
            if (index - jump >= 0) {
                int energy = solve(index - jump, heights, k, dp)
                        + Math.abs(heights[index] - heights[index - jump]);

                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return dp[index] = minEnergy;
    }

    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, heights, k, dp);
    }
}

// Bottom-Up DP (Tabulation)

public class Solution {

    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k; jump++) {

                if (i - jump >= 0) {
                    int energy = dp[i - jump]
                            + Math.abs(heights[i] - heights[i - jump]);

                    minEnergy = Math.min(minEnergy, energy);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }
}

// Space Optimization

public class Solution {

    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k; jump++) {

                if (i - jump >= 0) {
                    minEnergy = Math.min(
                            minEnergy,
                            dp[i - jump]
                                    + Math.abs(heights[i] - heights[i - jump])
                    );
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }
}
