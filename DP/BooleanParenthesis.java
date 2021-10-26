import java.util.Arrays;

public class BooleanParenthesis {
    /*
     * Given a boolean expression S of length N with following symbols. Symbols 'T'
     * ---> true 'F' ---> false and following operators filled between symbols
     * Operators & ---> boolean AND | ---> boolean OR ^ ---> boolean XOR Count the
     * number of ways we can parenthesize the expression so that the value of
     * expression evaluates to true.
     * 
     * Example 1:
     * 
     * Input: N = 7 S = T|T&F^T Output: 4 Explaination: The expression evaluates to
     * true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T))
     */
    public static void main(String[] args) {
        String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        System.out.println(countWays(s.length(), s));
    }

    static int dp[][][] = new int[201][201][3];

    static int countWays(int N, String S) {
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return solve(S, 0, S.length() - 1, 1);
    }

    static int solve(String s, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int ans = 0;
        int leftTrue, leftFalse, rightTrue, rightFalse;

        for (int k = i + 1; k < j; k += 2) {
            leftTrue = solve(s, i, k - 1, 1);
            leftFalse = solve(s, i, k - 1, 0);
            rightTrue = solve(s, k + 1, j, 1);
            rightFalse = solve(s, k + 1, j, 0);
            if (s.charAt(k) == '&') {
                if (isTrue == 1)
                    ans = ans + leftTrue * rightTrue;
                else {
                    ans = ans + leftFalse * rightFalse + leftFalse * rightTrue + leftTrue * rightFalse;
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1)
                    ans = ans + leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                else
                    ans = ans + leftFalse * rightFalse;
            } else if (s.charAt(k) == '^') {
                if (isTrue == 1)

                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue;
                else {
                    ans = ans + leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }
        return dp[i][j][isTrue] = ans % 1003;
    }
}
