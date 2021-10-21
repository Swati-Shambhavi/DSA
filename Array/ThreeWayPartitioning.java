import java.util.Arrays;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 3, 3, 4 };
        int a = 1;
        int b = 2;
        System.out.println(Arrays.toString(arr));
        threeWayPartition(arr, a, b);
        System.out.println(Arrays.toString(arr));
    }

    public static void threeWayPartition(int arr[], int a, int b) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int i = 0;
        while (i <= end) {
            if (arr[i] < a) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
            } else if (arr[i] > b) {
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
            } else
                i++;
        }

    }

}
