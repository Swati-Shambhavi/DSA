public class SmallSUbarraySumGreaterThanEqualToX {
    public static void main(String[] args) {
        // int[] arr = { 2, 3, 1, 2, 4, 3 };
        // int target = 7;//asn=2
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 15; // my ans=0; real ans=5

        System.out.println(minSubArrayLen(target, arr));
    }

    public static int minSubArrayLen(int target, int[] arr) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        int n = arr.length;
        while (end < n) {
            while (sum < target && end < n) {
                sum += arr[end++];
            }
            while (sum >= target && start < n) {
                if (ans > end - start) {
                    ans = end - start;
                }
                sum -= arr[start++];
            }
        }
        return ans > n ? 0 : ans;
    }
}
