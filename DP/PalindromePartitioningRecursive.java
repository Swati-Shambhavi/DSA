public class PalindromePartitioningRecursive {
    /*
     * Given a string str, a partitioning of the string is a palindrome partitioning
     * if every sub-string of the partition is a palindrome. Determine the fewest
     * cuts needed for palindrome partitioning of given string.
     * 
     * Example 1: Input: str = "ababbbabbababa" Output: 3 Explaination: After 3
     * partitioning substrings are "a", "babbbab", "b", "ababa".
     */
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    static int palindromicPartition(String str) {
        return solve(str, 0, str.length() - 1);

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

    static int solve(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + solve(str, i, k) + solve(str, k + 1, j);
            minAns = Math.min(minAns, temp);
        }
        return minAns;
    }
}
