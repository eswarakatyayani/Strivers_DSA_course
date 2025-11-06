/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Examples:
Input : str = ["flowers" , "flow" , "fly", "flight" ]
Output : "fl"
Explanation :
All strings given in array contains common prefix "fl".
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Step 1: Find the shortest string
        String prefix = strs[0];
        for (String s : strs) {
            if (s.length() < prefix.length()) {
                prefix = s;
            }
        }

        // Step 2: Compare with all strings
        for (String s : strs) {
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }  
}
