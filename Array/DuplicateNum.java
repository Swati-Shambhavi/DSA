
// public static int findDuplicate(int[] arr) {
//     int ans = -1;
//     int i = 0;
//     while (i < arr.length) {
//         if (arr[i] != i + 1) {
//             int correct = arr[i] - 1;
//             if (arr[correct] == arr[i]) {
//                 return arr[i];
//             } else {
//                 swap(arr, correct, i);
//             }
//         } else {
//             i++;
//         }
//     }
//     return ans;
// }
/*
Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
*/
public class DuplicateNum {
    public static void main(String[] args) {
        // int[] arr = { 1, 3, 4, 2, 2 };
        int[] arr = { 8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18 };
        System.out.println(findDuplicate(arr));
    }

    // Revision:1
    public static int findDuplicate(int[] arr) {
        int ans = -1;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[correct] == arr[i]) {
                    return arr[i];
                }
                swap(arr, correct, i);
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
