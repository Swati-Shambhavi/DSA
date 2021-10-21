import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println(Arrays.toString(calculateSpan(arr, arr.length)));
    }

    public static int[] calculateSpan(int arr[], int n) {
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                ans[index++] = -1;
            } else if (stack.peek()[0] > arr[i]) {
                ans[index++] = stack.peek()[1];
            } else if (stack.peek()[0] <= arr[i]) {
                while (stack.size() > 0 && stack.peek()[0] <= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    ans[index++] = -1;
                } else {
                    ans[index++] = stack.peek()[1];
                }
            }
            stack.push(new int[] { arr[i], i });
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i - ans[i];
        }
        // System.out.println(stack);
        return ans;
    }
}
