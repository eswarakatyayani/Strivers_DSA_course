/*
Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the maximum profit achievable by buying and selling the stock at most once. 
The stock should be purchased before selling it, and both actions cannot occur on the same day.
Examples:
Input: arr = [10, 7, 5, 8, 11, 9]
Output: 6

Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.

*/


class Solution {
    public int stockBuySell(int[] arr, int n) {
        
        // Find index of smallest element
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Find index of largest element
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        // Apply your condition
        if (minIndex <= maxIndex) {
            return 0;
        } else {
            return arr[maxIndex] - arr[minIndex];
        }
    }
}
