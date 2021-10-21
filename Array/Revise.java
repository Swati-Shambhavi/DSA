
// import java.util.ArrayList;
import java.util.Arrays;
// import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Revise {
    public static void main(String[] args) {
        // int[] arr = { 1, 5, 7, 1 }; // k=6
        int[] arr = { 1, 1, 1, 1 };
        ;// k=2 ans=6

        int k = 2;
        System.out.println("Answer=" + getPairsCount(arr, arr.length, k));
    }

    static int getPairsCount(int[] arr, int n, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < n) {
            int temp = k - arr[i];

            if (map.containsKey(arr[i])) {
                ans += map.get(arr[i]);
            }

            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }

            System.out.println(map + "\t i=" + i);

            i++;

        }
        return ans;
    }
}
