class KthLargestUsingHeap {

    // Heapify for 1-based index
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= n && arr[left] > arr[largest])   //For Leaf nodes left > n Condition fail
            largest = left;

        if (right <= n && arr[right] > arr[largest])   //For Leaf nodes right > n Condition fail
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static int kthLargestElement(int[] nums, int k) {
        int n = nums.length;

        // Create index 1-based array for heap
        int[] heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heap[i + 1] = nums[i];
        }

        // BUILD HEAP: n/2 down to 1
        for (int i = n / 2; i >= 1; i--) {
            heapify(heap, n, i);
        }

        // HEAP SORT (extract max k-1 times): n down to 2
        for (int i = n; i >= n - k + 2; i--) {
            int temp = heap[1];
            heap[1] = heap[i];
            heap[i] = temp;
            heapify(heap, i - 1, 1);
        }

        return heap[1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kthLargestElement(arr, k)); // 5
    }
}
