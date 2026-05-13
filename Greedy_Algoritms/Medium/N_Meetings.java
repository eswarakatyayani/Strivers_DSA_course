// N_Meetings.java
import java.util.*;

// Activity / Meeting class
class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution {

    // Function to find maximum meetings in one room
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {

        ArrayList<Meeting> meetings = new ArrayList<>();

        // Store meetings with index
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort by ending time
        Collections.sort(meetings, (a, b) -> {
            if (a.end == b.end) {
                return a.pos - b.pos;
            }
            return a.end - b.end;
        });

        ArrayList<Integer> ans = new ArrayList<>();

        // Pick first meeting
        ans.add(meetings.get(0).pos);
        int freeTime = meetings.get(0).end;

        // Check remaining meetings
        for (int i = 1; i < meetings.size(); i++) {

            // If current meeting starts after previous ends
            if (meetings.get(i).start > freeTime) {
                ans.add(meetings.get(i).pos);
                freeTime = meetings.get(i).end;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end   = {5, 4, 2, 9, 7, 9};

        int n = start.length;

        ArrayList<Integer> result = maxMeetings(n, start, end);

        System.out.println("Meetings that can be performed:");
        System.out.println(result);

        System.out.println("Count = " + result.size());
    }
}
