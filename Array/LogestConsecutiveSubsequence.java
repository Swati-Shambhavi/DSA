
import java.util.HashSet;
import java.util.Set;

public class LogestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(findLongestConseqSubseq(arr, arr.length));

    }

    static int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        // { 2, 6, 1, 9, 4, 5, 3 }
        int longestLen = 0;
        int currentLen;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int num = arr[i];
                currentLen = 1;
                while (set.contains(num + 1)) {
                    currentLen += 1;
                    num += 1;
                }
                longestLen = Math.max(longestLen, currentLen);
            }
        }

        return longestLen;
    }
}
