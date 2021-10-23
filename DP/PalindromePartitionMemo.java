public class PalindromePartitionMemo {

    /*
     * Given a string str, a partitioning of the string is a palindrome partitioning
     * if every sub-string of the partition is a palindrome. Determine the fewest
     * cuts needed for palindrome partitioning of given string.
     * 
     * Example 1:
     * 
     * Input: str = "ababbbabbababa" Output: 3 Explaination: After 3 partitioning
     * substrings are "a", "babbbab", "b", "ababa".
     */
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    static int[][] dp = new int[500][500];

    static int palindromicPartition(String str) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // written 2 memoized solutions
        // return solveMemo(str, 0, str.length() - 1);
        return solveMemoOptimized(str, 0, str.length() - 1);

    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int solveMemoOptimized(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left, right;
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = solveMemoOptimized(str, i, k);
                dp[i][k] = left;
            }
            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = solveMemoOptimized(str, k + 1, j);
                dp[k + 1][j] = right;
            }
            int temp = 1 + left + right;
            minAns = Math.min(minAns, temp);
        }
        return dp[i][j] = minAns;
    }

    static int solveMemo(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + solveMemo(str, i, k) + solveMemo(str, k + 1, j);
            minAns = Math.min(minAns, temp);
        }
        return dp[i][j] = minAns;
    }
}
