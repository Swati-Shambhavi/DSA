import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchInMatrix {

    /*
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties: * Integers in each row are sorted
     * from left to right. The first integer of each row is greater than the last
     * integer of the previous row. Input: matrix =
     * [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 Output: true Input:
     * matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13 Output: false
     * 
     */

    public static void main(String[] args) {
        // int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // int target = 13;
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        // int[][] matrix = { { 1, 2 } };
        // int target = 2;
        // int[][] matrix = { { 1 } };
        // int target = 2;

        // 1 2 13 13 22 28 31 33 34 34 36 38 40 48 49 51 52 53 55 56 59 60 60 60 61 63
        // 63 64 67 70 62 63 64 66 68 71
        // 62
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_element = matrix[mid / col][mid % col];
            if (mid_element == target) {
                return true;
            } else if (target < mid_element) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
