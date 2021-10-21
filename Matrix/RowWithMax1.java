public class RowWithMax1 {
    public static void main(String[] args) {

        // int arr[][] = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0
        // } };
        int[][] arr = { { 0, 0 }, { 0, 0 } };
        System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
    }
    // { 0, 1, 1, 1 }
    // { 0, 0, 1, 1 }
    // { 1, 1, 1, 1 }

    // Optimized
    static int rowWithMax1s(int arr[][], int n, int m) {
        int row = -1;
        int countOf1inIthRow = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            countOf1inIthRow = BNS(arr, i);
            if (countOf1inIthRow > maxCount) {
                maxCount = countOf1inIthRow;
                row = i;
            }
        }
        return row;
    }

    static int BNS(int[][] arr, int i) {
        int count = 0;
        int start = 0, end = arr[0].length - 1;
        int firstIndexOf1 = arr[0].length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[i][mid] == 1) {
                firstIndexOf1 = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        count = arr[0].length - firstIndexOf1;
        return count;
    }
    // //Brute force
    // static int rowWithMax1s(int arr[][], int n, int m) {
    // int ans = Integer.MAX_VALUE;
    // int row = -1;

    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < m; j++) {
    // System.out.println("loop");
    // if (arr[i][j] == 1) {
    // // ans = Math.min(ans, j);
    // if (j < ans) {
    // ans = j;
    // row = i;
    // }
    // System.out.println("i=" + i + " j=" + j);
    // break;
    // }
    // }
    // }

    // return row;
    // }
}