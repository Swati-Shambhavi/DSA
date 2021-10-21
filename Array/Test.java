import java.util.Arrays;

// Below is the implementation of the above approach

public class Test {
    public static void main(String[] args) {

        int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;

        System.out.println("Original " + Arrays.toString(arr));
        rearrange(arr, n);
        System.out.println("RearrangeD array is " + Arrays.toString(arr));

    }

    // Utility function to right rotate all elements
    // between [outofplace, cur]
    static void rightrotate(int arr[], int n, int outofplace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }

    static void rearrange(int arr[], int n) {
        int outofplace = -1;

        for (int i = 0; i < n; i++) {
            if (outofplace >= 0) {
                if (((arr[i] >= 0) && (arr[outofplace] < 0)) || ((arr[i] < 0) && (arr[outofplace] >= 0))) {
                    rightrotate(arr, n, outofplace, i);

                    if (i - outofplace >= 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }
            if (outofplace == -1) {
                // check if current entry is out-of-place
                if (((arr[i] >= 0) && ((i & 0x01) == 0)) || ((arr[i] < 0) && (i & 0x01) == 1))
                    outofplace = i;
            }
        }
    }

}