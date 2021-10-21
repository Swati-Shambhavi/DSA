public class PartitioinEqualSUbsetSum {
    public static void main(String[] args) {
        // Example 1:

        // Input: N = 4
        // arr = {1, 5, 11, 5}
        // Output: YES
        // Explaination:
        // The two parts are {1, 5, 5} and {11}.
        // Example 2:

        // Input: N = 3
        // arr = {1, 3, 5}
        // Output: NO
        // Explaination: This array can never be
        // partitioned into two such parts.
        int[] arr = { 1, 5, 11, 5 };
        System.out.println(equalPartition(arr.length, arr));
    }

    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // if the sum is zero, we can never divide it into 2 equal parts
        if (sum % 2 != 0) {
            return 0;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[N + 1][sum + 1];
        int row = 0;
        for (int col = 0; col < dp[0].length; col++) {
            dp[row][col] = false;
        }
        int col = 0;
        for (row = 0; row < dp.length; row++) {
            dp[row][col] = true;
        }
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum] == true ? 1 : 0;
    }
}
