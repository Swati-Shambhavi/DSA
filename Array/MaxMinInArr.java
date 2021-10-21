public class MaxMinInArr {
    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        System.out.println(max(arr));
        // System.out.println(min(arr));
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }
}