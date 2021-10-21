public class LongestCommonSubseq {
    public static void main(String[] args) {
        String text1 = "abcdezzzggg", text2 = "acezzgg";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(lcsBottomUp(text1, text2));

    }

    // Longest common subseq bottom up approach
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

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = lcs(text1.length(), text2.length(), text1, text2, dp);
        return ans;
    }

    static int lcs(int n, int m, String s1, String s2, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        } else {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                return dp[n][m] = 1 + lcs(n - 1, m - 1, s1, s2, dp);
            } else {
                return dp[n][m] = Math.max(lcs(n, m - 1, s1, s2, dp), lcs(n - 1, m, s1, s2, dp));
            }
        }
    }
}
