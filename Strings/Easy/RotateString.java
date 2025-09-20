/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.
Examples:
Input : s = "abcde" , goal = "cdeab"
Output : true
*/
class Solution {   
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false; 
        }
        char firstChar = goal.charAt(0);  
        int i = s.indexOf(firstChar);     
        if (i == -1) {
            return false; 
        }
        String substr = s.substring(i) + s.substring(0, i);  
        return substr.equals(goal); 
    }
}
