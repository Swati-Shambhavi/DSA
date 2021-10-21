import java.util.PriorityQueue;

public class KthSmallestNum {
    public static void main(String[] args) {
        int arr[] = { 99, 88, 77, 66, 22, 33, 44, 11, 55 };
        System.out.println(kthSmallest(arr, 0, 7, 5));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // Brute force
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 1; j < arr.length; j++) {
        // if (arr[j - 1] > arr[j]) {
        // int temp = arr[j - 1];
        // arr[j - 1] = arr[j];
        // arr[j] = temp;
        // }
        // }
        // }
        // return arr[k - 1];
        int min = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        System.out.println(pq);

        for (int i = 1; i <= k; i++) {
            if (i == k) {
                min = pq.poll();
            } else {
                pq.poll();
            }

        }
        return min;
    }
}
