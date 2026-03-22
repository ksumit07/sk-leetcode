package intervals;

import java.util.*;

/*
    MEETING ROOMS I

    Question:
    Given an array of meeting time intervals where intervals[i] = [start_i, end_i],
    determine if a person can attend all meetings.

    Return true if no meetings overlap, otherwise return false.

    Two meetings overlap if:
    start of one meeting < end of another meeting.

    --------------------------------------------------

    Example 1:

    Input:
    intervals = [[0,30],[5,10],[15,20]]

    Output:
    false

    Explanation:
    [0,30] overlaps with [5,10] and [15,20]

    --------------------------------------------------

    Example 2:

    Input:
    intervals = [[7,10],[2,4]]

    Output:
    true

    Explanation:
    Meetings do not overlap.

    --------------------------------------------------

    Example 3:

    Input:
    intervals = [[1,5],[5,10]]

    Output:
    true

    Explanation:
    meetings touch but do not overlap.

    --------------------------------------------------

    Edge Cases:

    single meeting
    [[5,10]]
    Output: true

    same start time
    [[1,4],[1,3]]
    Output: false

    nested meeting
    [[1,10],[2,3]]
    Output: false

    already sorted
    [[1,2],[3,4],[5,6]]
    Output: true

    unsorted input
    [[5,10],[0,3],[3,5]]
    Output: true

*/

public class MeetingRoom {

    // Implement this
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][][] testCases = {

                { { 0, 30 }, { 5, 10 }, { 15, 20 } },
                { { 7, 10 }, { 2, 4 } },
                { { 1, 5 }, { 5, 10 } },
                { { 5, 10 } },
                { { 1, 4 }, { 1, 3 } },
                { { 1, 10 }, { 2, 3 } },
                { { 1, 2 }, { 3, 4 }, { 5, 6 } },
                { { 5, 10 }, { 0, 3 }, { 3, 5 } }
        };

        boolean[] expected = {

                false,
                true,
                true,
                true,
                false,
                false,
                true,
                true
        };

        for (int i = 0; i < testCases.length; i++) {

            boolean actual = canAttendMeetings(testCases[i]);

            System.out.println("Intervals : " + Arrays.deepToString(testCases[i]));
            System.out.println("Expected  : " + expected[i]);
            System.out.println("Actual    : " + actual);

            if (actual == expected[i]) {
                System.out.println("Result    : PASS");
            } else {
                System.out.println("Result    : FAIL");
            }

            System.out.println("-----------------------------------");
        }
    }
}