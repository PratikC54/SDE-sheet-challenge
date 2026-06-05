package Day_3;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/description/">...</a>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */

/*
Intuition

The main challenge is efficiently detecting overlapping intervals.

A useful observation is that if the intervals are sorted by their starting point, any interval can only overlap with the interval immediately before it in the sorted order. This eliminates the need to compare every interval with every other interval.

We first sort the intervals by their start time. Then, while traversing the sorted intervals:

If the current interval starts before or at the end of the last merged interval, they overlap, so we merge them by extending the end point.
Otherwise, there is no overlap, and we start a new interval in the result.

By always maintaining the most recently merged interval, we can process all intervals in a single pass after sorting.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void merge(int[][] intervals) {
        if (intervals.length == 0 ) return ;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i=1;i< intervals.length;i++) {
            int[] current = intervals[i];
            int[] last = merged.getLast();

            if (current[0] < last[1]) last[1] = Math.max(current[1],last[1]);
            else merged.add(current);
        }
        display(merged.toArray(new int[merged.size()][]));
    }

    static void display(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}
