import java.util.PriorityQueue;

public class MinCostOfRopes {
    public static void main(String[] args) {
        long arr[] = { 4, 2, 7, 6, 9 };
        System.out.println(minCost(arr, arr.length));
    }

    static long minCost(long arr[], int n) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            long first = pq.poll();
            if (pq.isEmpty()) {
                break;
            }
            long second = pq.poll();
            long cost = first + second;
            sum += cost;
            pq.add(cost);
        }
        return sum;
    }
}
