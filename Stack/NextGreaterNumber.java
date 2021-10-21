
import java.util.Arrays;
import java.util.Stack;

//FInd the next greater element
//Aditya verma vid
public class NextGreaterNumber {
    public static void main(String[] args) {
        long[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nextGreaterNumber(arr, arr.length)));
    }

    static void reverse(long[] ans) {
        int i = 0, j = ans.length - 1;
        while (i <= j) {
            long temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
    }

    static long[] nextGreaterNumber(long[] arr, int n) {
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();

        n = n - 1;
        int index = 0;
        for (int i = n; i >= 0; i--) {
            if (stack.empty()) {
                ans[index++] = -1;
            } else if (stack.peek() > arr[i]) {
                ans[index++] = stack.peek();
            } else if (stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    ans[index++] = -1;

                } else {
                    ans[index++] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        reverse(ans);
        return ans;
    }

}