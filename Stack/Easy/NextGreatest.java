/*
Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.
The next greater element of an element in the array is the nearest element on the right that is greater than the current element.
If there does not exist a next greater element for the current element, then the next greater element for that element is -1.

Example 1
Input: arr = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
*/
class Solution {
    public int[] nextLargerElement(int[] arr) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                s.push(arr[i]);
                arr[i] = -1;
            }
            else if (s.peek() > arr[i]) {
                int temp = s.peek();
                s.push(arr[i]);
                arr[i] = temp;
            }
            else {
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    s.push(arr[i]);
                    arr[i] = -1;
                } else {
                    int temp = s.peek();
                    s.push(arr[i]);
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
