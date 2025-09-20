/*
Largest Odd Number in a String
Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.
The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)
Examples:
Input : s = "5347"
Output : "5347"
*/

/*
Look at the last digit of the string.
If it is odd, the entire string is already the largest odd number. return it.
If it is even, ignore the last and check the previous char.
If that’s odd, then the substring up to this digit is the largest odd number.
Keep repeating (moving left) until:
You find an odd digit → return everything up to that digit.
If you reach the start and no odd digit is found → return "".
Finally, strip any leading zeros from the result, since the answer should not start with zero.
*/

class Solution {    
    public String largeOddNum(String s) {
    char[] ch = s.toCharArray();
    for(int i=ch.length-1; i>=0;i--)
         if((ch[i] - '0') %2 !=0)
         {
                String result = s.substring(0, i + 1);
                result = result.replaceFirst("^0+", "");
                return result;
         }

  return "";
    }
}
