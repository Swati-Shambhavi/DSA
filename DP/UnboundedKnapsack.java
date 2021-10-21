public class UnboundedKnapsack {
    public static void main(String[] args) {
        int N = 2, W = 3, val[] = { 1, 1 }, wt[] = { 2, 1 };
        System.out.println(knapSack(N, W, val, wt));
    }

    static int knapSack(int n, int W, int val[], int wt[]) {

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
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
