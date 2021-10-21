public class KnapSackMemoize {
    static int[][] dp = new int[1002][1002];

    public static void main(String[] args) {
        // Example 2:

        // Input:
        // N = 3
        // W = 3
        // values[] = {1,2,3}
        // weight[] = {4,5,6}
        // Output: 0
        int[] wt = { 4, 5, 1 };
        int[] val = { 1, 2, 3 };
        int W = 4, n = 3;
        // int n = 3, W = 3;
        // int val[] = { 1, 2, 3 }, wt[] = { 4, 5, 6 };
        System.out.println(knapSack(W, wt, val, n));
    }

    static int helper(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[W][n] != -1) {
            return dp[W][n];
        }
        if (wt[n - 1] <= W) {
            return dp[W][n] = Math.max(val[n - 1] + helper(W - wt[n - 1], wt, val, n - 1), helper(W, wt, val, n - 1));
            // return dp[W][n];
        } else {
            return dp[W][n] = helper(W, wt, val, n - 1);
        }
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(W, wt, val, n);

    }
}
