import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = { 4, 8, 5, 2, 25 };
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }

    static void reverse(int[] ans) {
        int i = 0, j = ans.length - 1;
        while (i <= j) {
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
    }

    static int[] nextSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        // int[] arr = { 4, 8, 5, 2, 25 };/
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                ans[index++] = -1;
            } else if (stack.peek() < arr[i]) {
                ans[index++] = stack.peek();
            } else if (stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
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
