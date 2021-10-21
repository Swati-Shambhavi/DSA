import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        long[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nesrestGreaterToLeft(arr)));
    }

    static long[] nesrestGreaterToLeft(long[] arr) {
        long[] ans = new long[arr.length];
        Stack<Long> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            if (stack.empty()) {
                ans[index++] = -1;
            } else if (arr[i] < stack.peek()) {
                ans[index++] = stack.peek();
            } else if (arr[i] >= stack.peek()) {
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
        return ans;
    }
}
