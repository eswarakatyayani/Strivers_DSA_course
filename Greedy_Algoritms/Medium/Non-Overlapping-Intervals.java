/*
This is same as the N meeting rooms one in Easy section of greddy algorithms
*/
import java.util.*;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals based on ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int lastEndTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // If current interval does not overlap
            if (intervals[i][0] >= lastEndTime) {

                count++;
                lastEndTime = intervals[i][1];
            }
        }

        // Minimum intervals to remove
        return intervals.length - count;
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int result = eraseOverlapIntervals(intervals);

        System.out.println("Minimum intervals to remove: " + result);
    }
}
