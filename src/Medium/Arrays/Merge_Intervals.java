package Medium.Arrays;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Merge_Intervals {

    public static boolean isOverlapping(int[]x, int[]y){
        int x1 = x[0], x2 = x[1], y1 = y[0], y2 = y[1];
        if((x1 <= y1 && y1 <= x2) || ((x1 <= y2 && y2 <= x2)))
            return true;
        if((y1 <= x1 && x1 <= y2) || ((y1 <= x2 && x2 <= y2)))
            return true;
        return false;
    }

    public static int[][] merge(int[][] intervals) {
        HashMap<Integer, Integer> limits = new HashMap<>();
        int[] startingPoints = new int[intervals.length];
        Arrays.fill(startingPoints, -1);
        for(int i = 0; i <  intervals.length; i++){
            if(!limits.containsKey(intervals[i][0])) {
                limits.put(intervals[i][0], intervals[i][1]);
                startingPoints[i] = intervals[i][0];
            }
            else if(intervals[i][1] > limits.get(intervals[i][0])){
                limits.put(intervals[i][0], intervals[i][1]);
            }
        }
        Arrays.sort(startingPoints);
        int i;
        for(i = 0; i < startingPoints.length; i++)
            if(startingPoints[i] != -1)
                break;

        ArrayList<int[]> resultList = new ArrayList<>();
        int[] i1 = {startingPoints[i], limits.get(startingPoints[i])};
        resultList.add(i1);
        for(; i < startingPoints.length; i++){
            if(startingPoints[i] == -1 || startingPoints[i] == i1[0])
                continue;
            int[] currentInterval = {startingPoints[i], limits.get(startingPoints[i])};
            int[] lastInterval = resultList.get(resultList.size()-1);
            if(isOverlapping(currentInterval, lastInterval)){
                int start = Math.min(currentInterval[0], lastInterval[0]);
                int end = Math.max(currentInterval[1], lastInterval[1]);
                int[] mergedInterval = {start, end};
                resultList.remove(resultList.size()-1);
                resultList.add(mergedInterval);
            }
            else
                resultList.add(currentInterval);
        }
        int[][] result = new int[resultList.size()][2];
        for(int j = 0; j < result.length; j++)
            result[j] = resultList.get(j);
        return result;
    }

    public static void main(String[] args) {
        int[][] i = {{1,3},{2,6},{8,10},{15,18}, {1,4}};
        System.out.println(Arrays.toString(merge(i)[2]));
    }
}
