package intervals;

import java.security.cert.CertPathValidatorException.Reason;
import java.util.*;

/*
    MEETING ROOMS II

    Question:
    Given an array of meeting time intervals where intervals[i] = [start_i, end_i],
    return the minimum number of conference rooms required.

    A meeting room can only be used if the next meeting starts AFTER or AT the time
    the previous meeting ends.

    Constraints:
    - 1 <= intervals.length <= 10^4
    - 0 <= start_i < end_i <= 10^6

    --------------------------------------------------

    Example 1:
    Input:
    intervals = [[0,30],[5,10],[15,20]]

    Output:
    2

    Explanation:
    Meeting [0,30] overlaps with both [5,10] and [15,20]
    so we need at least 2 rooms.

    --------------------------------------------------

    Example 2:
    Input:
    intervals = [[7,10],[2,4]]

    Output:
    1

    Explanation:
    No overlap, so only 1 room needed.

    --------------------------------------------------

    Example 3:
    Input:
    intervals = [[1,5],[2,6],[3,7],[4,8]]

    Output:
    4

    Explanation:
    All meetings overlap.

    --------------------------------------------------

    Edge Cases:

    1 meeting
    [[5,10]]
    Output: 1

    meetings touching but not overlapping
    [[1,5],[5,10]]
    Output: 1

    same start time
    [[1,4],[1,3],[1,2]]
    Output: 3

    nested meetings
    [[1,10],[2,3],[4,5],[6,7]]
    Output: 2

    empty input (not typical in LC but good practice)
    []
    Output: 0
*/

public class MeetingRoomsII {

    // Implement this
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Reason 1 — Not sorted
        // You're comparing adjacent elements without sorting first. Adjacent in the array doesn't mean adjacent in time.
        // Reason 2 — Rooms can be reused, not just counted
        // Even after sorting, just counting overlaps doesn't account for freed rooms:

        for(int[] interval: intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval[0]){
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {

        int[][][] testCases = {

                {{0,30},{5,10},{15,20}},
                {{7,10},{2,4}},
                {{1,5},{2,6},{3,7},{4,8}},
                {{5,10}},
                {{1,5},{5,10}},
                {{1,4},{1,3},{1,2}},
                {{1,10},{2,3},{4,5},{6,7}}
        };

        int[] expected = {
                2,
                1,
                4,
                1,
                1,
                3,
                2
        };

        for(int i = 0; i < testCases.length; i++){

            int actual = minMeetingRooms(testCases[i]);

            System.out.println("Intervals : " + Arrays.deepToString(testCases[i]));
            System.out.println("Expected  : " + expected[i]);
            System.out.println("Actual    : " + actual);

            if(actual == expected[i]){
                System.out.println("Result    : PASS");
            } else {
                System.out.println("Result    : FAIL");
            }

            System.out.println("-----------------------------------");
        }
    }
}