import java.util.Arrays;

/*
Count Inversions 
Medium Accuracy: 39.43% Submissions: 100k+ Points: 4
Given an array of integers. Find the Inversion Count in the array. 
Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Example 1:
Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).

Example 2:
Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.

Example 3:
Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
*/
public class CountInversons {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCount(arr, arr.length));
        System.out.println(Arrays.toString(arr));

    }

    static int merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[(end - start + 1)];
        int i = start;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        // int[] arr = { 2, 4, 1, 3, 5 };
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
                // swaps += (m + 1) - (l + i);
                count += (mid + 1) - (start + i);
            }
            k++;
        }
        if (i > mid) {
            while (j <= end) {
                temp[k++] = arr[j++];
            }
        } else {
            while (i <= mid) {
                temp[k++] = arr[i++];
            }
        }
        for (int k2 = start; k2 <= end; k2++) {
            arr[k2] = temp[k2 - start];
        }
        return count;
    }

    static int merge_sort(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += merge_sort(arr, start, mid);
            count += merge_sort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    static int inversionCount(int arr[], int N) {

        return merge_sort(arr, 0, N - 1);

        // Brute force
        // int count = 0;

        // for (int i = 0; i < N; i++) {
        // for (int j = i + 1; j < N - 1; j++) {
        // if (i < j && arr[i] > arr[j]) {
        // count++;
        // }
        // }
        // }
        // return count;
    }
}
