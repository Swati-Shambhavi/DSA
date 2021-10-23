public class Revise {
    public static void main(String[] args) {
        String str = "aaabba";
        System.out.println(palindromicPartition(str));
    }

    static int dp[][] = new int[501][501];

    static int palindromicPartition(String str) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(str, 0, str.length() - 1);
    }

    static int solve(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalin(str, i, j))
            return 0;

        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + solve(str, i, k) + solve(str, k + 1, j);
            minAns = Math.min(minAns, temp);
        }
        return dp[i][j] = minAns;
    }

    static boolean isPalin(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
