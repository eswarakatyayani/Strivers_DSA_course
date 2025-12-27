class Solution {
    public int[] nextSmallerElements(int[] arr) {
       Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    s.push(arr[i]);
                    arr[i] = -1;
                } else if (s.peek() < arr[i]) {
                int temp = s.peek();
                s.push(arr[i]);
                arr[i] = temp;
                }
        }
        return arr;
    }
}
