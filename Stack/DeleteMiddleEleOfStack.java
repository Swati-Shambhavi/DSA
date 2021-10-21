import java.util.Stack;

public class DeleteMiddleEleOfStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(333);
        s.push(90);
        s.push(32);
        s.push(3);
        s.push(41);
        System.out.println(s);
        s = deleteMid(s);
        System.out.println(s);
        System.out.println(findMidEle(s));
    }

    static int action(Stack<Integer> s, int k) {
        if (k == 1) {
            return s.peek();
        }
        s.pop();
        return action(s, k - 1);
    }

    // finds the middle element
    static int findMidEle(Stack<Integer> s) {
        int mid = action(s, (s.size() / 2 + 1));
        return mid;
    }

    // deletes the middle element
    static Stack<Integer> deleteMid(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int k = stack.size() / 2 + 1;
        removeMid(stack, k);
        return stack;
    }

    static void removeMid(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }
        int last = stack.pop();
        removeMid(stack, k - 1);
        stack.push(last);
    }
}
