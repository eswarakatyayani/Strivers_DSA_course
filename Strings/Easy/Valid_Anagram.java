/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Examples:
Input : s = "anagram" , t = "nagaram"
Output : true
*/
class Solution {  
    public boolean anagramStrings(String s, String t) {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        String sortedStr1 = new String(chars1); 
        String sortedStr2 = new String(chars2); 
        return sortedStr1.equals(sortedStr2);
    }
}
