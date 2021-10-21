import java.util.Arrays;

public class MedianOf2SortedUnequalLengthArray {
    public static void main(String[] args) {
        // int a[] = { 1, 3 }, b[] = { 2 };;
        // int[] a = { 1, 2 }, b = { 3, 4 };
        // int a[] = { 1, 4, 6, 7, 8 }, b[] = { 2, 3, 5 };
        // int a[] = { 1, 4, 6, 7 }, b[] = { 2, 3, 5, 8, 10, 11 };
        // int[] a = {}, b = { 1, 2, 3 };
        int[] a = { 1, 2, 3, 4 }, b = {};

        System.out.println(findMedianSortedArrays(a, b));
    }

    static void swap(int[] a, int b[], int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    static boolean isOdd(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        if ((aLen + bLen) % 2 != 0) {
            return true;
        } else
            return false;
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        double median = 0;
        int aLen = a.length;
        int bLen = b.length;
        int k = aLen - 1;
        int i = 0, j = 0;
        while (i <= k && j < bLen) {
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
        int mid = (aLen + bLen) / 2;
        int first = 0, second = 0;

        if (isOdd(a, b)) {
            median = mid < aLen ? a[mid] : b[mid - aLen];
            return median;
        } else {
            if (mid < aLen) {
                first = a[mid];
                second = a[mid - 1];
            } else if ((mid - 1) < aLen) {
                first = a[mid - 1];
                second = b[0];
            } else {
                first = b[mid - aLen - 1];
                second = b[mid - aLen];
            }
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        return (double) (first + second) / 2;
    }
}
