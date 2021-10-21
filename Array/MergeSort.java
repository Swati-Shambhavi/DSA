import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 5, 3, 2, 8, 9 };
        System.out.println(Arrays.toString(arr));
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    static void merge_sort(int[] arr, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;

            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        if (i > mid) {
            while (j <= end) {
                temp[index] = arr[j];
                index++;
                j++;
            }
        } else {
            while (i <= mid) {
                temp[index] = arr[i];
                index++;
                i++;
            }
        }
        for (int j2 = start; j2 <= end; j2++) {
            arr[j2] = temp[j2 - start];
        }
    }
}
