import java.util.HashSet;
import java.util.Set;

// Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.// Example 1:
// Input:
// 5
// 4 2 -3 1 6
// Output: 
// Yes
// Explanation: 
// 2, -3, 1 is the subarray 
// with sum 0.

// Example 2:
// Input:
// 5
// 4 2 0 1 6
// Output: 
// Yes
// Explanation: 
// 0 is one of the element 
// in the array so there exist a 
// subarray with sum 0.
public class Subarray0Sum {
    public static void main(String[] args) {
        // int[] arr = { 4, 2, -3, 1, 6 };
        // int[] arr = { 0, 9, 7, -12, 5 };
        // int[] arr = { 10, -10 };
        int[] arr = { -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0 };
        System.out.println(findsum(arr, arr.length));
    }

    static boolean findsum(int arr[], int n) {
        if (n == 1 && arr[0] == 0)
            return true;

        // Optimized
        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || sums.contains(sum)) {
                return true;
            }
            sums.add(sum);
        }

        // Brute force
        // int curr = -1;
        // for (int i = 0; i < n; i++) {
        // if (arr[i] == 0) {
        // return true;
        // }
        // curr = arr[i];
        // for (int j = i + 1; j < n; j++) {
        // curr += arr[j];
        // if (curr == 0) {
        // return true;
        // }
        // }

        // }
        return false;
    }
}
