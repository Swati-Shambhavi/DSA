import java.util.Arrays;

public class Merge2ArrWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 0, 2, 6, 8, 9 };
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Arr1= " + Arrays.toString(arr1));
        System.out.println("Arr2= " + Arrays.toString(arr2));
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        // Optimized 2nd method: Time: O(Nlog(N))

        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                swap(arr1, k, arr2, j);
                k--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Optimized 1st; Time: O(n*m)
        // int j = 0;
        // for (int i = 0; i < n; i++) {
        // if (arr1[i] > arr2[j]) {
        // swap(arr1, i, arr2, j);
        // reshuffle(arr2, j);
        // } else {
        // j++;
        // }
        // }

        // brute force
        // int ans[] = new int[n + m];
        // int index = 0;
        // for (int i = 0; i < arr2.length; i++) {
        // ans[index] = arr2[i];
        // index++;
        // }
        // for (int i = 0; i < arr1.length; i++) {
        // ans[index] = arr1[i];
        // index++;
        // }
        // Arrays.sort(ans);
        // index = 0;
        // for (int i = 0; i < arr1.length; i++) {
        // arr1[i] = ans[index];
        // index++;
        // }
        // for (int i = 0; i < arr2.length; i++) {
        // arr2[i] = ans[index];
        // index++;
        // }

    }

    static void swap(int a[], int i, int[] b, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reshuffle(int arr2[], int start) {
        for (int i = start; i < arr2.length - 1; i++) {
            if (arr2[i] > arr2[i + 1]) {
                swap(arr2, i, i + 1);
            } else {
                return;
            }
        }
    }

}
