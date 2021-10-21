import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int arr[] = { 0, 2, 1, 2, 0 };
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort012(int[] arr) {
        int start = 0, end = arr.length - 1, i = 0;
        while (i <= end) {
            if (arr[i] == 0) {
                swap(arr, start, i);
                start++;
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, end);
                end--;

            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
