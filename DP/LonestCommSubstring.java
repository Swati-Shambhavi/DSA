public class LonestCommSubstring {
    public static void main(String[] args) {
        String S1 = "ABCDGH", S2 = "ACDGHR";
        System.out.println(longestCommonSubstr(S1, S2, S1.length(), S2.length()));
    }

    static int longestCommonSubstr(String s1, String s2, int m, int n) {
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
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
