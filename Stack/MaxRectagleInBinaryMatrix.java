import java.util.Arrays;
import java.util.Stack;

public class MaxRectagleInBinaryMatrix {
    public static void main(String[] args) {
        int M[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maxArea(M, M.length, M[0].length));
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {

        int arr[] = new int[matrix[0].length];
        for (int i = 0; i < arr.length; i++) {
            if (matrix[0][i] == '0') {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        int leetMax = largestRectangleArea(arr);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] = arr[j] + 1;
                }

            }
            // System.out.println(Arrays.toString(arr));
            leetMax = Math.max(leetMax, largestRectangleArea(arr));
        }

        return leetMax;
    }

    public static int maxArea(int M[][], int n, int m) {
        int arr[] = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = M[0][i];
        }
        int max = largestRectangleArea(arr);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 0) {
                    arr[j] = 0;
                } else {
                    arr[j] += M[i][j];
                }

            }
            // System.out.println(Arrays.toString(arr));
            max = Math.max(max, largestRectangleArea(arr));
        }

        return max;
    }

    public static int largestRectangleArea(int[] arr) {
        int area = Integer.MIN_VALUE;
        int[] left = smallerIndexInLeft(arr);
        int[] right = smallerIndexInRight(arr);
        int[] curr_area = new int[arr.length];
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(arr));

        // System.out.println(Arrays.toString(right));
        for (int i = 0; i < arr.length; i++) {
            int width = right[i] - left[i] - 1;
            curr_area[i] = width * arr[i];
            // System.out.print(" i= " + i + "|" + width);
        }
        for (int i = 0; i < curr_area.length; i++) {
            area = Math.max(area, curr_area[i]);

        }
        return area;
    }

    static void reverse(int[] ans) {
        int i = 0, j = ans.length - 1;
        while (i <= j) {
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
    }

    static int[] smallerIndexInLeft(int[] arr) {
        int[] left = new int[arr.length];
        int psudo_index = -1;
        int index = 0;
        Stack<int[]> stack = new Stack<>();
        // { 2, 1, 5, 6, 2, 3 };
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                left[index++] = psudo_index;
            } else if (stack.peek()[0] < arr[i]) {
                left[index++] = stack.peek()[1];
            } else if (stack.peek()[0] >= arr[i]) {
                while (stack.size() > 0 && stack.peek()[0] > arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    left[index++] = psudo_index;
                } else {
                    left[index++] = stack.peek()[1];
                }
            }
            stack.push(new int[] { arr[i], i });
        }
        return left;
    }
    // { 2, 1, 5, 6, 2, 3 };

    static int[] smallerIndexInRight(int[] arr) {
        int[] right = new int[arr.length];
        int index = 0, psudo_index = arr.length;
        Stack<int[]> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                right[index++] = psudo_index;
            } else if (stack.peek()[0] < arr[i]) {
                right[index++] = stack.peek()[1];

            } else if (stack.peek()[0] >= arr[i]) {
                while (stack.size() > 0 && stack.peek()[0] >= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    right[index++] = psudo_index;
                } else {
                    right[index++] = stack.peek()[1];
                }
            }
            stack.push(new int[] { arr[i], i });
        }
        reverse(right);
        return right;
    }
}
