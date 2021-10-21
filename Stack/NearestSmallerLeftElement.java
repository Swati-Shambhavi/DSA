import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerLeftElement {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        System.out.println(nearestSmallerLeft(arr));
    }

    static List<Integer> nearestSmallerLeft(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                list.add(-1);
            } else if (stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.add(arr[i]);

        }
        return list;
    }
}
