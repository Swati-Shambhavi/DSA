public class MinInsersionDeletion {
    public static void main(String[] args) {
        String str1 = "heap", str2 = "pea";
        System.out.println(minOperations(str1, str2));
    }

    public static int minOperations(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int numOfInsertion = n - lcsBottomUp(text1, text2);
        int numOfDeletion = m - lcsBottomUp(text1, text2);
        return numOfDeletion + numOfInsertion;
    }

    public static int lcsBottomUp(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
