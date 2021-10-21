public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "abac", Y = "cab";
        System.out.println(shortestCommonSupersequence(X, Y, X.length(), Y.length()));
        System.out.println(printShortestCommonSupersequence(X, Y, X.length(), Y.length()));
        System.out.println("Expected: cabac");

    }

    static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }

    public static String printShortestCommonSupersequence(String text1, String text2, int m, int n) {
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
        int i = m, j = n;
        String ans = "";
        while (j > 0 && i > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans += text1.charAt(i - 1);
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    ans += text1.charAt(i - 1);

                    i--;
                } else {
                    ans += text2.charAt(j - 1);

                    j--;
                }
            }
        }
        while (i > 0) {
            ans += text1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            ans += text2.charAt(j - 1);
            j--;
        }
        return reverse(ans);
    }

    public static int shortestCommonSupersequence(String text1, String text2, int m, int n) {
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
        int common = dp[m][n];
        int ans = m + n - common;

        return ans;
    }
}
