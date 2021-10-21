public class CountSubsetsWithGivenSUm {
    public static void main(String[] args) {
        // Input: arr[] = {1, 2, 3, 3}, X = 6
        // Output: 3
        // All the possible subsets are {1, 2, 3},
        // {1, 2, 3} and {3, 3}

        // Input: arr[] = {1, 1, 1, 1}, X = 1
        // Output: 4
        int[] arr = { 1, 1, 1, 1 };
        int sum = 1;
        System.out.println(countSubsets(arr, sum, arr.length));
    }

    static int countSubsets(int[] arr, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
