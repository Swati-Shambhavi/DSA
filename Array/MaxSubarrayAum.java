public class MaxSubarrayAum {
    public static void main(String[] args) {
        int arr[] = { -1, -2, -3, -4 };
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    static long maxSubarraySum(int arr[], int n) {
        long sum = arr[0];
        long sumSoFar = sum;
        for (int i = 1; i < arr.length; i++) {
            sumSoFar = Math.max(sumSoFar + arr[i], arr[i]);
            sum = Math.max(sum, sumSoFar);
        }
        return sum;

    }
}
