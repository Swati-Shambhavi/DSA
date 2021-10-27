import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//solved in 3 ways
//1st using matrix for dp
//2nd used maps
//3rd Binary search + matrix
public class EggDrop {
    public static void main(String[] args) {
        System.out.println(eggDrop(2, 10));
        System.out.println(superEggDrop(2, 6));

    }

    static int[][] dp = new int[201][201];
    static Map<String, Integer> map;

    // leetcode TLE
    // k=eggs, n=floors
    // public static int superEggDrop(int k, int n) {
    // map = new HashMap<>();
    // return solveLeet(k, n);
    // }

    // public static int solveLeet(int eggs, int floor) {
    // String key = eggs + " " + floor;
    // if (map.containsKey(key)) {
    // return map.get(key);
    // }
    // if (eggs == 1) {
    // map.put(key, floor);
    // return floor;
    // }
    // if (floor <= 1) {
    // map.put(key, floor);
    // return floor;
    // }

    // int ans = Integer.MAX_VALUE;
    // for (int curFloor = 1; curFloor <= floor; curFloor++) {
    // int caseWithBrokenEgg, caseWithUnbrokenEgg;
    // String curKey1 = (eggs - 1) + " " + (curFloor - 1);
    // String curKey2 = eggs + " " + (floor - curFloor);

    // if (map.containsKey(curKey1)) {
    // caseWithBrokenEgg = map.get(curKey1);
    // } else {
    // caseWithBrokenEgg = solveLeet(eggs - 1, curFloor - 1);
    // map.put(curKey1, caseWithBrokenEgg);
    // }
    // if (map.containsKey(curKey2)) {
    // caseWithUnbrokenEgg = map.get(curKey2);
    // } else {
    // caseWithUnbrokenEgg = solveLeet(eggs, floor - curFloor);
    // map.put(curKey2, caseWithUnbrokenEgg);
    // }
    // int temp = 1 + Math.max(caseWithBrokenEgg, caseWithUnbrokenEgg);
    // ans = Math.min(ans, temp);
    // }
    // map.put(key, ans);
    // return ans;
    // }

    // leetode worked
    public static int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }

    private static int helper(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }

        int low = 1, high = N, result = N;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = helper(K - 1, mid - 1, memo);
            int right = helper(K, N - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        memo[K][N] = result;
        return result;
    }

    // gfg
    static int eggDrop(int n, int k) {

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return solve(n, k);
    }

    static int solve(int eggs, int floor) {
        if (eggs == 1) {
            return floor;
        }
        if (floor <= 1) {
            return floor;
        }
        if (dp[eggs][floor] != -1) {
            return dp[eggs][floor];
        }
        int ans = Integer.MAX_VALUE;
        for (int curFloor = 1; curFloor <= floor; curFloor++) {
            int temp = 1 + Math.max(solve(eggs - 1, curFloor - 1), solve(eggs, floor - curFloor));
            ans = Math.min(ans, temp);
        }
        return dp[eggs][floor] = ans;
    }
}
