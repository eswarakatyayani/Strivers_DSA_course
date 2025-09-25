/*
Roman numerals are represented by seven different symbols:
I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000
Roman numerals are typically written from largest to smallest, left to right. However, in specific cases, a smaller numeral placed before a larger one indicates subtraction.
The following subtractive combinations are valid:
I before V (5) and X (10) → 4 and 9
X before L (50) and C (100) → 40 and 90
C before D (500) and M (1000) → 400 and 900

Given a Roman numeral, convert it to an integer.
Examples:
Input: s = "III"
Output: 3
Explanation: III = 1 + 1 + 1 = 3

Input: s = "XLII"
Output: 42
Explanation: XL = 40, II = 2 → 40 + 2 = 42
*/


/*
Step 1: Check if the next symbol is larger or smaller
If the next symbol is larger → subtract the current symbol from the next symbol (subtractive case).
If the next symbol is smaller or equal → add the current symbol to the total (additive case).

Step 2: Move to the next symbol
If you did a subtraction, skip the next symbol (because you already processed it).
If you did an addition, move to the next symbol normally.

NOTE:
Only I, X, C can be used in subtraction.
I before V or X → 4 (IV) or 9 (IX)
X before L or C → 40 (XL) or 90 (XC)
C before D or M → 400 (CD) or 900 (CM)
*/

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if (i < s.length() - 1 && map.get(s.charAt(i+1)) > map.get(s.charAt(i)))
            {
                    if((s.charAt(i)=='I' && (s.charAt(i+1)=='V'|| s.charAt(i+1)=='X')) ||
                    (s.charAt(i)=='X' && (s.charAt(i+1)=='L'|| s.charAt(i+1)=='C')) ||
                    (s.charAt(i)=='C' && (s.charAt(i+1)=='D'|| s.charAt(i+1)=='M'))
                    )
                    result+=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                    i++;
            }
            else 
            result+=map.get(s.charAt(i));
        }
    return result;
    }
    }










