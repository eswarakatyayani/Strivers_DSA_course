/*

A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Example 1:
Input: s = "(()())(())"
Output: "()()()"

*/

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack();
        StringBuilder result = new StringBuilder();
      
        for (char c : s.toCharArray())  //converting Each letter in String to character array. 
        {
            if(c=='(')
            {
                if(!stack.isEmpty())
                {
                    result.append(c);
                }
                stack.push(c);
            }
          else if(c==')'){
           stack.pop();
                if (!stack.isEmpty()) {
                    result.append(c); 
                }

    }}
      return result.toString();
}
}
