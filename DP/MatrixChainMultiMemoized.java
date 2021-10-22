public class MatrixChainMultiMemoized {
    public static void main(String[] args) {
        int arr[] = { 40, 20, 30, 10, 30 };
        System.out.println(matrixMultiplication(arr.length, arr));
    }

    static int[][] dp = new int[101][501];

    static int matrixMultiplication(int n, int arr[]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(arr, 1, n - 1);
    }

    static int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            minAns = Math.min(minAns, tempAns);
        }
        return dp[i][j] = minAns;
    }
}
