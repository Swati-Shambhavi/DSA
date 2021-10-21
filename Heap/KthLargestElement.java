import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        // int arr[] = { 7, 10, 4, 3, 20, 15 };
        int[] arr = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(kthSmallest(arr, 0, arr.length, k));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
