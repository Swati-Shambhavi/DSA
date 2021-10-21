public class SubsetSumProblem {
    public static void main(String[] args) {
        // N = 6
        // arr[] = {3, 34, 4, 12, 5, 2}
        // sum = 9
        // Output: 1
        // Explanation: Here there exists a subset with
        // sum = 9, 4+3+2 = 9.
        // Example 2:

        // Input:
        // N = 6
        // arr[] = {3, 34, 4, 12, 5, 2}
        // sum = 30
        // Output: 0
        // Explanation: There is no subset with sum 30.
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 30;
        System.out.println(isSubsetSum(arr.length, arr, sum));

    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }

            }
        }
        /*
         * Same as the above code in O(n) complexity for (int i = 0; i < dp[0].length;
         * i++) { dp[0][i] = false; } for (int i = 0; i < dp.length; i++) { dp[i][0] =
         * true; } dp[0][0] = true;
         */
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum];
    }
}
