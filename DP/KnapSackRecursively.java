public class KnapSackRecursively {
    /*
     * N = 3 W = 4 values[] = {1,2,3} weight[] = {4,5,1} Output: 3
     */

    public static void main(String[] args) {
        // Example 2:

        // Input:
        // N = 3
        // W = 3
        // values[] = {1,2,3}
        // weight[] = {4,5,6}
        // Output: 0
        int[] wt = { 4, 5, 1 };
        int[] val = { 1, 2, 3 };
        int W = 4, n = 3;
        // int n = 3, W = 3;
        // int val[] = { 1, 2, 3 }, wt[] = { 4, 5, 6 };
        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int wt[], int val[], int n) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
        } else {
            return knapSack(W, wt, val, n - 1);
        }
    }
}