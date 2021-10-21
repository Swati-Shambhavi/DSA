public class KnapsackBottomUp {
    public static void main(String[] args) {
        int[] wt = { 4, 5, 1 };
        int[] val = { 1, 2, 3 };
        int W = 4, n = 3;
        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        // int ans = 0;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
