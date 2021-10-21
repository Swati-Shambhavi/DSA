public class TargetSum {
    public static void main(String[] args) {
        // int[] arr = { 1, 1, 2, 3 };
        // int diff = 1;
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        int diff = 1;
        System.out.println(countOfSubset(arr, diff));
    }

    static int countOfSubset(int[] arr, int dif) {
        int sumOfArray = 0;
        int countOfZeros = 0;
        for (int i : arr) {
            if (i == 0) {
                countOfZeros++;
            }
            sumOfArray += i;
        }
        // sub1 - sub2 = dif
        // sub1 + sub2 = sumOfArray
        // -------------------------
        // 2sub1 = dif + sumOfArray
        // sub1 = (dif + sumOfArray)/2
        // we need to find the subarray whose sum = (dif + sumOfArray)/2
        // sub1=subarray1
        if (dif > sumOfArray) {
            return 0;
        }
        if ((dif + sumOfArray) % 2 != 0) {
            return 0;
        }
        int desiredSum = (dif + sumOfArray) / 2;
        int countOfSubarrayWithDesiredSum = countOfSubarray(arr, desiredSum, arr.length);
        return (int) (Math.pow(2, countOfZeros) * countOfSubarrayWithDesiredSum);
    }

    static int countOfSubarray(int[] arr, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
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
