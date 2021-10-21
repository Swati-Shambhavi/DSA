public class SmallestSubArrWithSumGreaterThanX {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 0, 19 };
        int x = 51; // ans=3
        System.out.println(smallestSubWithSum(arr, arr.length, x));
    }

    public static int smallestSubWithSum(int arr[], int n, int x) {

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int end = 0;
        int start = 0;
        while (end < n) {
            while (sum <= x && end < n)
                sum += arr[end++];

            while (sum > x && start < n) {
                if (end - start < ans) {
                    ans = end - start;
                }
                sum -= arr[start++];
            }
        }
        return ans;
    }
}
