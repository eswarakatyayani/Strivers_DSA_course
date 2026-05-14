class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        if (n == 1)
            return 1;
        int sum = 1;
        int i = 1;

        while (i < n) {
            // Equal ratings
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            // Increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                // Peak correction
                if (down >= peak)
                    sum++;
                down++;
            }
        }

        return sum;
    }
}

/*
Time  : O(N)
Space : O(1)
*/
