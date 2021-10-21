import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/
public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        // int[][] arr = { { 1, 4 }, { 0, 4 } };
        int[][] ans = merge(arr);
        System.out.println();
        for (int[] row : ans) {
            System.out.print(Arrays.toString(row) + " ");
        }
    }

    static public int[][] merge(int[][] arr) {

        List<int[]> ans = new ArrayList<>();
        if (arr.length <= 1) {
            return arr;
        }
        // int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        int start = arr[0][0];
        int end = arr[0][1];

        for (int[] i : arr) {
            if (i[0] <= end) {
                end = Math.max(i[1], end);
            } else {
                ans.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }

        ans.add(new int[] { start, end });

        return ans.toArray(new int[0][]);

        // My SOlution
        // int[][] ans = new int[arr.length][arr[0].length];
        // int row = 0;
        // Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        // ans[0][0] = arr[0][0];
        // for (int i = 0; i < arr.length - 1; i++) {
        // if (arr[i][1] < arr[i + 1][0]) {
        // ans[row][1] = arr[i][1];
        // row++;
        // if (i + 1 < arr.length)
        // ans[row][0] = arr[i + 1][0];
        // }
        // }
        // ans[row][1] = arr[arr.length - 1][1];

        // int n = 0;
        // for (int i = 0; i < ans.length; i++) {
        // if (ans[i][0] > 0) {
        // n++;
        // }
        // }
        // int[][] finalAns = new int[n][2];
        // for (int i = 0; i < n; i++) {
        // finalAns[i][0] = ans[i][0];
        // finalAns[i][1] = ans[i][1];
        // }
        // return finalAns;
    }
}
