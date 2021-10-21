import java.util.Arrays;

public class CyclicRotationBy1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = 5;
        rotate(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int arr[], int n) {
        int last = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = last;
    }
}
