/*
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, max = 0;

        // stores last index of each character
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);

            // if character already seen and inside current window
            if (hashMap.containsKey(c) && hashMap.get(c) >= l) {
                l = hashMap.get(c) + 1;
            }

            hashMap.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
