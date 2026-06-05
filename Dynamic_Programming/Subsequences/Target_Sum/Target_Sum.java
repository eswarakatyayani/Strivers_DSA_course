import java.util.*;

class Solution {

    static final int MOD = 1000000007;
    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }
    private int solve(int index, int sum, int[] nums, int target) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        String key = index + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long positive = solve( index + 1, sum + nums[index], nums, target);
        long negative = solve(index + 1, sum - nums[index], nums, target);
        int ans = (int)((positive + negative) % MOD);
        memo.put(key, ans);

        return ans;
    }
}
