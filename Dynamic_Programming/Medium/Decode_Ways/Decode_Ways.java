// Decode Ways.
/*
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
*/
// Recursive Solution (Brute Force)
public class DecodeWaysRecursive {

    public int numDecodings(String s) {
        return solve(0, s);
    }

    private int solve(int index, String s) {
        // Reached end => one valid decoding
        if (index == s.length()) {
            return 1;
        }

        // Strings starting with 0 are invalid
        if (s.charAt(index) == '0') {
            return 0;
        }

        // Take one digit
        int ways = solve(index + 1, s);

        // Take two digits if valid (10-26)
        if (index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));

            if (num >= 10 && num <= 26) {
                ways += solve(index + 2, s);
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        DecodeWaysRecursive obj = new DecodeWaysRecursive();
        System.out.println(obj.numDecodings("2112")); // 5
    }
}

// Memoization Solution (Top-Down DP)

import java.util.Arrays;
public class DecodeWaysMemoization {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    private int solve(int index, String s, int[] dp) {

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ways = solve(index + 1, s, dp);

        if (index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));

            if (num >= 10 && num <= 26) {
                ways += solve(index + 2, s, dp);
            }
        }

        return dp[index] = ways;
    }

    public static void main(String[] args) {
        DecodeWaysMemoization obj = new DecodeWaysMemoization();
        System.out.println(obj.numDecodings("2112")); // 5
    }
}
