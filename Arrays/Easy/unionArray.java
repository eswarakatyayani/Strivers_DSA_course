/*

Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.

Examples:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
Output: [1, 2, 3, 4, 5, 7]
*/

import java.util.Arrays;
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int nums3[] = new int[n + m]; 
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || nums3[k - 1] != nums1[i]) {
                    nums3[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                if (k == 0 || nums3[k - 1] != nums1[i]) {
                    nums3[k++] = nums1[i];
                }
                i++;
            } else {
                if (k == 0 || nums3[k - 1] != nums2[j]) {
                    nums3[k++] = nums2[j];
                }
                j++;
            }
        }

        while (i < n) {
            if (k == 0 || nums3[k - 1] != nums1[i]) {
                nums3[k++] = nums1[i];
            }
            i++;
        }

        while (j < m) {
            if (k == 0 || nums3[k - 1] != nums2[j]) {
                nums3[k++] = nums2[j];
            }
            j++;
        }

        return Arrays.copyOf(nums3, k);
    }
}
