import java.util.Arrays;

public class MinSwapsToMakeArrayPallindorme {

    /*
     * Input : arr[] = {15, 4, 15} Output : 0 Array is already a palindrome. So we
     * do not need any merge operation.
     * 
     * Input : arr[] = {1, 4, 5, 1} Output : 1 We can make given array palindrome
     * with minimum one merging (merging 4 and 5 to make 9)
     * 
     * Input : arr[] = {11, 14, 15, 99} Output : 3 We need to merge all elements to
     * make a palindrome.
     */

    public static void main(String[] args) {
        // int[] a = { 15, 4, 15 };
        int[] a = { 1, 5, 4, 1 }; // ans=1
        // int[] a={11, 14, 15, 99}; //ans=3
        System.out.println(Arrays.toString(a));

        System.out.println(minSwaps(a));
    }

    static int minSwaps(int[] arr) {
        int swap = 0;
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                // need to merge from tail.
                j--;
                arr[j] += arr[j + 1];
                swap++;
            }

            // Else we merge left two elements
            else {
                i++;
                arr[i] += arr[i - 1];
                swap++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return swap;
    }
}
