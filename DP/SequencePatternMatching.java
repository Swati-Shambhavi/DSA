public class SequencePatternMatching {
    // We have to find whether String s1 is present as a subsequence in String s2 or
    // not. We have to return either True/False

    // Sol: We can find the lcs of both the strings and check whether lcs is equal
    // to the length of string s1, if yes return true else return false
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dgaoibppcl";
        System.out.println(seqPatternMatching(s1, s2));
    }

    static boolean seqPatternMatching(String s1, String s2) {
        return (s1.length() == lcs(s1, s2)) ? true : false;
    }

    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
