/*
Time Complexity: O(N), since traversing the given string takes O(N) time, each element is pushed onto and popped from the stack at most once in worst-case taking o(N) time, removing the remaining digits (if k > 0) takes O(k) time which can go upto O(N) in worst-case and forming the result, trimming the zeros and reversing the digits takes O(N) time.
Space Complexity: O(N), since we are using a stack to store the digits of the resulting number, in the worst case, the stack can contain all the digits of the input string.
*/

/*
Use a stack to store digits of the resulting number
Iterate through each digit of the input string
While the stack is not empty, the current digit is smaller than the top of the stack, and k is greater than 0, pop from the stack and decrement k
Push the current digit onto the stack
If k is still greater than 0 after the iteration, remove digits from the end of the stack
Collect the remaining digits from the stack to form the result
Remove any leading zeroes from the result
If the result is empty after removing zeroes, return "0"

Edge Cases:
If k is equal to the length of the input string, return "0" as all digits will be removed
If the result contains leading zeroes, remove them before returning
If no digits were removed during iteration and k is still greater than 0, remove the last k digits from the stack

*/
import java.util.Stack;
class Solution {
    
    // Function to find the smallest possible integer after removing k digits
    public String removeKdigits(String nums, int k) {
        // Stack to store digits
        Stack<Character> st = new Stack<>();

        // Traverse the given string
        for (int i = 0; i < nums.length(); i++) {
            char digit = nums.charAt(i); // Current digit

            // Pop last digits if a smaller digit is found and k > 0
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // Remove the last digit
                k--; // Decrement k by 1
            }

            // Push the current digit
            st.push(digit);
        }

        // If more digits can be removed
        while (k > 0) {
            st.pop(); // Pop the last added digits
            k--; // Decrement k by 1
        }

        // Handle edge case: if stack is empty
        if (st.isEmpty()) return "0";

        // StringBuilder to store the result
        StringBuilder res = new StringBuilder();

        // Add digits from stack to result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Trim the leading zeros
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        // Reverse the string to get the correct number
        res.reverse();

        // If result is empty, return "0"
        if (res.length() == 0) return "0";

        // Return the result as a string
        return res.toString();
    }
}

// Separate class containing the main method
public class Main {
    public static void main(String[] args) {
        String nums = "541892"; // Input number as string
        int k = 2; // Number of digits to remove

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the function to find the smallest number after removing k digits
        String ans = sol.removeKdigits(nums, k);

        // Print the result
        System.out.println("The smallest possible integer after removing k digits is: " + ans);
    }
}
