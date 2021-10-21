import java.util.Arrays;

//Move all negative numbers to beginning and positive to end with constant extra space
public class MovePosNegElement {
    public static void main(String[] args) {
        int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int s = 0, e = arr.length - 1;
        int i = 0;
        while (i < e) {
            if (arr[i] < 0) {
                swap(arr, s, i);
                s++;
                i++;
            } else if (arr[i] > 0) {
                swap(arr, e, i);
                e--;
                i++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
