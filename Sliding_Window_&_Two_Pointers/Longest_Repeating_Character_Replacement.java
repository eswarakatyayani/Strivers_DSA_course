/*
//Longest Substring with atmost K different characters
Given an integer k and a string s, any character in the string can be selected and changed to any other uppercase English character. This operation can be performed up to k times. After completing these steps, return the length of the longest substring that contains the same letter.
Example 1
Input : s = "BAABAABBBAAA" , k = 2
Output : 6
Explanation : we can change the B present at index 0 , 3 (0 base indexing) to A.
The new string is "AAAAAABBBAAA".
The substring "AAAAAA" is the longest substring having same letter with length 6.

Example 2
Input : s = "AABABBA" , k = 1
Output : 4
Explanation : The underlined characters are changed in the new string obtained.
The new string is "AABBBBA". The substring "BBBB" is the answer.
There are other ways to achieve this answer.

*/


class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            // if replacements needed > k, shrink window
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
