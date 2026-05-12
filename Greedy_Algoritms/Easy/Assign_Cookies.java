import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] greed, int[] size) {

        int n = greed.length;
        int m = size.length;

        Arrays.sort(greed);
        Arrays.sort(size);

        int l = 0;
        int r = 0;

        // l -> cookies pointer
        // r -> children pointer

        while (l < m && r < n) {
            // if current cookie can satisfy current child
            if (size[l] >= greed[r]) {
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String[] args) {

        int[] greed = {1, 2, 3};
        int[] size = {1, 1};
        int ans = findContentChildren(greed, size);
        System.out.println("Content Children: " + ans);
    }
}

/*
Time complexity: 
Sorting: O(n log n + m log m)
While loop: O(n + m)

Overall:
O(n log n + m log m)
*/
