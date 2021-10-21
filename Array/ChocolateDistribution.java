import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {
    public static void main(String[] args) {
        long[] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int m = 5;
        System.out.println(findMinDiff(list, arr.length, m));
    }

    public static long findMinDiff(ArrayList<Long> list, long n, int m) {
        long res = Long.MAX_VALUE;
        Collections.sort(list);
        for (int i = 0; i < n - m; i++) {

            res = Math.min(res, (list.get(i + m - 1) - list.get(i)));
        }
        return res;
    }
}
