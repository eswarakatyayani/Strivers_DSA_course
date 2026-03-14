/*
Problem Summary:
You are given an array of server load deltas (can be positive or negative).
Find:
Maximum sum contiguous subarray
Starting index
Ending index

Input:
N = 8
arr = [-2, 1, -3, 4, -1, 2, 1, -5]
output: 6 3 6
*/

import java.util.*;

public class Main {

    static long[] findPeakLoadWindow(int N, int[] arr) {
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < N; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        return new long[]{maxSum, start, end};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long[] result = findPeakLoadWindow(N, arr);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        sc.close();
    }
}
