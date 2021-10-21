import java.util.Arrays;

public class MedianOf2SortedArrOfEqualSize {
    public static void main(String[] args) {
        int arr1[] = { 1, 12, 15, 26, 38 }, arr2[] = { 2, 13, 17, 30, 48 };
        System.out.println(findMedian(arr1, arr2, arr1.length));
    }

    static void swap(int[] a, int b[], int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    // static boolean areOddAndEqual(int[] a, int[] b) {
    // int lenA = a.length;
    // int lenB = b.length;
    // if (lenA == lenB && (lenA % 2 != 0))
    // return true;
    // else
    // return false;
    // }

    static int findMedian(int[] a, int[] b, int n) {
        // int median = 0;
        int k = n - 1;
        int i = 0;
        int j = 0;
        while (i < k) {
            if (a[i] > b[j]) {
                swap(a, b, k, j);
                k--;
                j++;
            } else {
                i++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);

        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        return (a[n - 1] + b[0]) / 2;
    }
}
