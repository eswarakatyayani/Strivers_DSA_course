public class MissingNumberXOR {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n; // start with n because range is 0..n
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 2, 3, 1, 4};
        System.out.println(missingNumber(nums1)); // 5

        int[] nums2 = {0, 1, 2, 4, 5, 6};
        System.out.println(missingNumber(nums2)); // 3
    }
}
