
public class TrappingRainWater {
    public static void main(String[] args) {
        // int arr[] = { 3, 0, 0, 2, 0, 4 };
        int[] arr = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trappingWater(arr));
    }

    static int trappingWater(int arr[]) {
        int ans = 0;
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int ansArr[] = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        for (int i = 0; i < right.length; i++) {
            ansArr[i] = Math.min(left[i], right[i]) - arr[i];
        }

        for (int i : ansArr) {
            ans += i;
        }

        return ans;
    }
}
