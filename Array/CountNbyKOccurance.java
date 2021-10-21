import java.util.HashMap;
import java.util.Map;

public class CountNbyKOccurance {

    // Count More than n/k Occurences
    // Given an array arr[] of size N and an element k. The task is to find all
    // elements in array that appear more than n/k times.
    // Example 1:
    // Input:
    // N = 8
    // arr[] = {3,1,2,2,1,2,3,3}
    // k = 4
    // Output: 2
    // Explanation: In the given array, 3 and
    // 2 are the only elements that appears
    // more than n/k times.
    // Example 2:

    // Input:
    // N = 4
    // arr[] = {2,3,3,2}
    // k = 3
    // Output: 2
    // Explanation: In the given array, 3 and 2
    // are the only elements that appears more
    // than n/k times. So the count of elements
    // are 2.

    public static void main(String[] args) {
        // int arr[] = { 3, 1, 2, 2, 1, 2, 3, 3 };
        // int k = 4;
        int[] arr = { 2, 3, 3, 2 };
        int k = 3; // ans=2
        System.out.println(countOccurence(arr, arr.length, k));
    }

    public static int countOccurence(int[] arr, int n, int k) {
        // { 3, 1, 2, 2, 1, 2, 3, 3 }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int occurance = map.get(arr[i]);
                map.replace(arr[i], occurance + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int ideal = n / k;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > ideal) {
                ans++;
            }
        }
        return ans;
    }
}
