import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {
        int X = 13;
        int arr[] = { 1, 4, 45, 6, 10, 8 };
        System.out.println(Arrays.toString(arr));
        System.out.println(find3Numbers(arr, arr.length, X));
        System.out.println(Arrays.toString(arr));

    }

    public static boolean find3Numbers(int arr[], int n, int x) {
        // Optimized; Time: O(n^2)

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int ideal = x - arr[i];
            int s = i + 1, e = n - 1;
            while (s < e) {
                if (arr[s] + arr[e] == ideal) {
                    return true;
                } else {
                    if (arr[s] + arr[e] > ideal) {
                        e--;
                    } else {
                        s++;
                    }
                }
            }
        }

        // Brute force Time: O(n^3)
        // for (int i = 0; i < n; i++) {
        // int num = arr[i];
        // int ideal = x - num;
        // for (int j = i + 1; j < arr.length; j++) {
        // for (int k = j + 1; k < arr.length; k++) {
        // if (arr[j] + arr[k] == ideal) {
        // return true;
        // }

        // }
        // }
        // }
        return false;
    }
}
