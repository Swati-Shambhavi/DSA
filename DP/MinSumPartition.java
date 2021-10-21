public class MinSumPartition {
    public static void main(String[] args) {
        int arr[] = { 1, 4 };
        System.out.println(minDifference(arr, arr.length));
    }

    public static int minDifference(int arr[], int n) {
        int range = 0;
        for (int i = 0; i < arr.length; i++) {
            range += arr[i];
        }
        boolean[][] dp = subsetSum(arr, range, n);
        int curr = 0;
        for (int i = range / 2; i >= 0; i--) {

            if (dp[n][i] == true) {
                System.out.println(i);
                curr = i;
                break;
            }
        }
        return range - 2 * curr;
    }

    static boolean[][] subsetSum(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
