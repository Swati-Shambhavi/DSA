import java.util.Arrays;

public class MinDiffInHeightOfTowers {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 10 };
        int k = 2, n = 4;
        System.out.println(getMinDiff(arr, n, k));
    }

    static int getMinDiff(int[] A, int n, int K) {
        // solution not figured out
        // Not mine => failed (youtube)
        // Arrays.sort(arr);
        // int ans = arr[n - 1] - arr[0];
        // for (int index = 1; index < arr.length - 1; index++) {
        // if (arr[index] >= k) {
        // int max = Math.max(arr[index - 1] + k, arr[n - 1] - k);
        // int min = Math.min(arr[0] + k, arr[index] - k);
        // ans = Math.min(ans, max - min);
        // }
        // }
        // return ans;
        // leetcode's solution=> failed
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N - 1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i + 1];
            int high = Math.max(A[N - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
        // My solution => failed
        // int mean = 0;
        // PriorityQueue<Integer> nums = new PriorityQueue<>();
        // for (int i = 0; i < n; i++) {
        // mean += arr[i];
        // }
        // mean = mean / n;
        // System.out.println("mean" + mean);
        // for (int i = 0; i < n; i++) {
        // // System.out.print(arr[i] + " ");
        // if (arr[i] + k <= mean) {
        // arr[i] += k;
        // } else if (arr[i] - k >= 0) {
        // arr[i] -= k;
        // } else {
        // arr[i] += k;
        // }
        // // System.out.println(arr[i]);
        // nums.add(arr[i]);
        // }
        // int min = nums.poll(), max = 0;
        // for (int i = 2; i <= n; i++) {
        // if (i == n) {
        // max = nums.poll();
        // } else {
        // nums.poll();
        // }
        // }
        // // System.out.println(min + " min, max " + max);
        // return max - min;
    }
}
