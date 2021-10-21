import java.util.HashMap;

/*
Count pairs with given sum 
Easy Accuracy: 41.59% Submissions: 77109 Points: 2
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:

Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.

*/
public class CountPairWithGivenSUm {
    public static void main(String[] args) {
        // int[] arr = { 1, 5, 7, 1 };
        int[] arr = { 1, 1, 1, 1 };

        int k = 2; // ans=2
        System.out.println("Answer=" + getPairsCount(arr, arr.length, k));
    }

    static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = k - arr[i];
            if (arr[i] >= k) {
                continue;
            }
            if (pairs.containsKey(arr[i])) {
                count += pairs.get(arr[i]);
            }
            if (pairs.containsKey(temp)) {
                pairs.replace(temp, pairs.get(temp) + 1);
            } else {
                pairs.put(temp, 1);
            }

        }
        return count;
        // brute force
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // // System.out.print(" i=" + i + ", j=" + j);
        // // if (i == j) {
        // // continue;
        // // }

        // if (arr[i] + arr[j] == k) {
        // count++;
        // System.out.println(" i=" + i + " j=" + j + " count= " + count);

        // }
        // // System.out.print(" pass\n");
        // }
        // }
    }
}
