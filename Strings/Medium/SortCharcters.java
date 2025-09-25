/*
Sort Characters by Frequency
You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
If two or more characters have same frequency then arrange them in alphabetic order.
Examples:
Input : s = "tree"
Output : ert
*/
class Solution {    
    public List<Character> frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
         List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
         list.sort((x, y) -> y.getValue() - x.getValue());
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.add(entry.getKey());
        }
        return result;
    }
}

/*
Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
Input: s = "tree"
Output: "eert"
*/
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char t=s.charAt(i);
            map.put(t,map.getOrDefault(t,0)+1);
        }
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((x,y)->y.getValue()-x.getValue());
        StringBuilder result=new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {

            for(int i=0;i<entry.getValue();i++)
            {
               result.append(entry.getKey());
            }
            
        }
        return result.toString();
    }
}
