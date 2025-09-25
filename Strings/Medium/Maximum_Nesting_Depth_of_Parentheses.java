/*
Maximum Nesting Depth of the Parentheses
A string s is a valid parentheses string (VPS) if it meets the following conditions:
It only contains digits 0-9, arithmetic operators +, -, *, /, and parentheses (, ).
The parentheses are balanced and correctly nested.
Your task is to compute the maximum nesting depth of parentheses in s. The nesting depth is the highest number of parentheses that are open at the same time at any point in the string.
Examples:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: The deepest nested sub-expression is ((8)/4), which has 3 layers of parentheses.
*/
class Solution {
    public int maxDepth(String st) {
      Stack<Character> s=new Stack<>();
      int count=0;
      List<Integer> l=new ArrayList<>();
      for(int i=0;i<st.length();i++)
      {
           if(st.charAt(i)=='(')
           {
            s.push(st.charAt(i));
            count++;
           }
           if(st.charAt(i)==')')
           {
            s.pop();
            l.add(count);
            count--;
           }
      }
        if (l == null || l.isEmpty()) {
            return 0;   }
      int max = l.get(0);
        for (int num : l) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
