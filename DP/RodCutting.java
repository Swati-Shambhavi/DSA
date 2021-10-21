public class RodCutting {
    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 8; // o/p=22
        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int price[], int n) {
        int[] len = new int[n];
        for (int i = 1; i <= n; i++) {
            len[i - 1] = i;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}
