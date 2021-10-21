import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockAtMostTwiceTransaction {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 }; // ans=6
        System.out.println("Ans=" + maxProfit(arr));
    }

    static int maxProfit(int[] arr) {

        int[] profit = new int[arr.length];
        Arrays.fill(profit, 0);
        System.out.println(Arrays.toString(profit));
        return 0;
    }
}
