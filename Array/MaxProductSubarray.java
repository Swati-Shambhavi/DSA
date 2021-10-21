public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = { 6, -3, -10, 0, 2 };// ans=180
        // int[] arr = { 3, 12, 15, 23, 33, -35, 30, -40, -30, -30, -30, 26, 28 };
        System.out.println(maxProduct(arr, arr.length));

    }

    static long maxProduct(int[] arr, int n) {
        long prod = Long.MIN_VALUE;
        long curr = 1;
        for (int i = 0; i < arr.length; i++) {
            curr *= arr[i];
            prod = Math.max(prod, curr);
            if (curr == 0) {
                curr = 1;
            }
        }
        curr = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            curr *= arr[i];
            prod = Math.max(curr, prod);
            if (curr == 0) {
                curr = 1;
            }
        }

        return prod;
    }
}
