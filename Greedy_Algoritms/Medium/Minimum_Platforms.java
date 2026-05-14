import java.util.Arrays;

public class Main {

    static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int cnt = 0;
        int maxCnt = 0;

        while (i < n && j < n) {

            // Train arrives
            if (arr[i] <= dep[j]) {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
                i++;
            }
            // Train departs
            else {
                cnt--;
                j++;
            }
        }

        return maxCnt;
    }

    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        int n = arr.length;

        int ans = findPlatform(arr, dep, n);

        System.out.println("Minimum platforms required = " + ans);
    }
}
