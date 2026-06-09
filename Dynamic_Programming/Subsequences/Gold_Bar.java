// Gold Bar (0/1 Knapsack)
// Knapsack Problem
/*
Problem Statement

A thief enters a gold mine carrying a bag with capacity W kg.
There are N gold bars, where:

weight[i] = weight of the ith gold bar
value[i] = value of the ith gold bar

The thief can either: Take the entire gold bar or Leave it. But he cannot break a gold bar.

Find the maximum value that can be carried in the bag.
Capacity W = 10

Gold Bars:
Weight  Value
1       60
2       100
3       120

Output: 280
*/

//Memoization
import java.util.Arrays;

public class KnapsackMemoization {

    static int solve(int index, int capacity,
                     int[] weight, int[] value,
                     int[][] dp) {

        // Base Case
        if (index == 0) {
            if (weight[0] <= capacity) {
                return value[0];
            }
            return 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        // Not Take
        int notTake = solve(index - 1, capacity, weight, value, dp);

        // Take
        int take = Integer.MIN_VALUE;

        if (weight[index] <= capacity) {
            take = value[index]
                    + solve(index - 1,
                            capacity - weight[index],
                            weight, value, dp);
        }

        return dp[index][capacity] = Math.max(take, notTake);
    }

    public static int knapsack(int W, int[] weight, int[] value) {

        int n = weight.length;

        int[][] dp = new int[n][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, W, weight, value, dp);
    }

    public static void main(String[] args) {

        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int W = 5;

        System.out.println(knapsack(W, weight, value));
    }
}

//Tabulation

public class KnapsackTabulation {

    public static int knapsack(int W, int[] weight, int[] value) {

        int n = weight.length;

        int[][] dp = new int[n][W + 1];

        // Base Case
        for (int cap = weight[0]; cap <= W; cap++) {
            dp[0][cap] = value[0];
        }

        for (int i = 1; i < n; i++) {

            for (int cap = 0; cap <= W; cap++) {

                int notTake = dp[i - 1][cap];

                int take = Integer.MIN_VALUE;

                if (weight[i] <= cap) {
                    take = value[i]
                            + dp[i - 1][cap - weight[i]];
                }

                dp[i][cap] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }

    public static void main(String[] args) {

        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int W = 5;

        System.out.println(knapsack(W, weight, value));
    }
}
