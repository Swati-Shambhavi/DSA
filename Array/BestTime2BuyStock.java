/*
 Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/
public class BestTime2BuyStock {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        // int[] arr = { 2, 1, 4 }; // exp o/p= 3, my=2
        // int[] arr = { 1, 4, 2 }; // o/p=3, my o/p=0
        // int[] arr = { 7, 6, 4, 3, 1 };
        System.out.println("Answer=" + maxProfit(arr));

    }

    public static int maxProfit(int[] arr) {
        int profit = 0;

        // Not my soln
        int buy = Integer.MAX_VALUE;
        // int profit=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < buy) {
                buy = arr[i];
            } else if (arr[i] - buy > profit) {
                profit = arr[i] - buy;
            }
        }
        return profit;

        // My SOlution
        // if (arr.length == 2) {
        // if (arr[0] < arr[1]) {
        // return arr[1] - arr[0];
        // } else {
        // return 0;
        // }
        // }
        // // [7,6,4,3,1]
        // int buy = arr[0], sell = 0;
        // for (int i = 1; i < arr.length - 1; i++) {
        // if (arr[i - 1] > arr[i]) {
        // buy = Math.min(buy, arr[i]);
        // }
        // if (arr[i + 1] < arr[i]) {
        // sell = Math.max(sell, arr[i]);
        // }
        // // System.out.println(arr[i]);
        // }
        // // sell = Math.max(sell, arr[arr.length - 1]);
        // System.out.println("Buy=" + buy + " Sell=" + sell);

        // profit = (sell - buy > 0) ? (sell - buy) : 0;
        // return profit;
    }
}
