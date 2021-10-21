import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int n = 7, k = 3;

        int arr[] = { 1, 23, 12, 9, 30, 2, 50 };
        System.out.println(Arrays.toString(kLargest(arr, n, k)));
    }

    static int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        Arrays.sort(arr);
        int s = 0, e = ans.length - 1;
        while (s < e) {
            swap(ans, s, e);
            s++;
            e--;
        }
        return ans;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
